create table allocate_relation
(
    id                bigint unsigned auto_increment comment '主键'
        primary key,
    gmt_create        datetime        not null comment '创建时间',
    gmt_modified      datetime        not null comment '修改时间',
    created_by        varchar(64)     not null comment '创建者',
    modified_by       varchar(64)     not null comment '修改者',
    project_no        varchar(64)     not null comment '项目编号',
    project_tag       int             not null comment '项目标签[0:idc建设  1:网络B&S 2：hub仓]',
    inventory_item_id bigint unsigned not null comment '库存id',
    item_type         int             not null comment '2:网络整机 3:网络原材料',
    tran_quantity     int             not null comment '交易数量',
    status            int             null comment '0:未分配   1:已分配',
    parent_id         bigint unsigned null comment '父id',
    bom_id            varchar(256)    null comment '物料编码',
    locator           varchar(64)     null comment '地域信息',
    tran_type         int             null comment '交易类型[0:冻结;1:保留可用;2:解冻;3:出库;4:入库;5:hub冻结]',
    box_num           varchar(128)    null comment '箱包号',
    price_tag         varchar(64)     null comment '计价标签',
    pack_size         varchar(64)     null comment '箱包规格',
    pack_qty          int             null comment '箱包数量',
    feature           json            null comment '扩展属性'
)
    comment '库存分配关系表' charset = utf8mb4;

create index idx_box_num
    on allocate_relation (box_num);

create index idx_inventory_item_id
    on allocate_relation (inventory_item_id);

create index idx_project_no
    on allocate_relation (project_no, project_tag, bom_id);

create table config_info
(
    id           bigint(64) unsigned auto_increment
        primary key,
    data_id      varchar(255) default '' not null,
    group_id     varchar(128) default '' not null,
    content      longtext                not null,
    md5          varchar(32)  default '' not null,
    src_ip       varchar(20)             null,
    src_user     varchar(20)             null,
    gmt_create   datetime                not null,
    gmt_modified datetime                not null,
    constraint uk_config_datagroup
        unique (data_id)
)
    comment '配置表' charset = utf8mb4;

create table group_info
(
    id           bigint(64) unsigned auto_increment
        primary key,
    address      varchar(70)  default ''                    not null,
    data_id      varchar(255) default ''                    not null,
    group_id     varchar(128) default ''                    not null,
    src_ip       varchar(20)                                null,
    src_user     varchar(20)                                null,
    gmt_create   datetime     default '2010-05-05 00:00:00' not null,
    gmt_modified datetime     default '2010-05-05 00:00:00' not null,
    constraint uk_group_address
        unique (address, data_id)
)
    comment '分组表' charset = utf8mb4;

create table inventory_item
(
    id                        bigint unsigned auto_increment comment '主键'
        primary key,
    inventory_category_id     bigint unsigned         not null comment '库存分类表ID',
    inventory_category_sub_id bigint unsigned         not null comment '库存分类子库表ID',
    category_id               bigint unsigned         not null comment '分类ID',
    item_id                   varchar(256)            not null comment '规格ID',
    brand_id                  bigint unsigned         not null comment '品牌ID',
    mpn_id                    varchar(256)            not null comment '制造部件ID',
    materiel_unit             tinyint unsigned        not null comment '物料单位（0：pic）',
    gmt_create                datetime                not null comment '创建时间',
    created_by                varchar(16)             not null comment '创建人',
    gmt_modified              datetime                not null comment '修改时间',
    modified_by               varchar(16)             not null comment '修改人',
    inventory_space           varchar(32)             not null comment '库存空间（0默认库位）',
    inventory_batch           varchar(32)             not null comment '库存批次',
    item_type                 tinyint unsigned        not null comment '项目类型（0部件，1整机,2:网络成品,3:网络原材料,4:整机柜）',
    inventory_quantity        int                     not null comment '库存数量',
    available_quantity        int                     not null comment '可用数量',
    freeze_quantity           int                     not null comment '冻结数量',
    item_part                 varchar(64) default '0' not null comment '整机一段机型',
    item_num                  varchar(256)            null comment '物料编码',
    feature                   json                    null comment '扩展属性',
    constraint uk_invenotry_mpn
        unique (inventory_category_sub_id, inventory_space, inventory_batch, item_type, item_num, mpn_id)
)
    comment '库存项目表' charset = utf8mb4;

create index idx_item_id
    on inventory_item (item_id);

create index idx_item_num
    on inventory_item (item_num);

create index idx_item_type
    on inventory_item (item_type);

create index idx_mpn
    on inventory_item (mpn_id);

create index idx_mpn_item_id_item_num
    on inventory_item (mpn_id, item_id, item_num);

create table tran_detail
(
    id                               bigint unsigned auto_increment comment '主键'
        primary key,
    tran_date                        datetime          not null comment '交易时间',
    tran_seq_no                      varchar(100)      not null comment '交易流水号',
    tran_category_id                 bigint unsigned   not null comment '交易分类表ID',
    category_id                      bigint unsigned   not null comment '分类ID',
    item_id                          varchar(256)      not null comment '规格ID',
    brand_id                         bigint unsigned   not null comment '品牌ID',
    mpn_id                           varchar(256)      not null comment '制造部件ID',
    inventory_category_id            bigint unsigned   not null comment '库存分类表ID',
    inventory_category_sub_id        bigint unsigned   not null comment '库存分类子库表ID',
    tran_quantity                    int unsigned      not null comment '交易数量',
    materiel_unit                    tinyint unsigned  not null comment '物料单位（0：pcs）',
    remark                           varchar(128)      null comment '备注',
    gmt_create                       datetime          not null comment '创建时间',
    created_by                       varchar(16)       not null comment '创建人',
    gmt_modified                     datetime          not null comment '修改时间',
    modified_by                      varchar(16)       not null comment '修改人',
    tran_order_no                    varchar(64)       null comment '交易订单号',
    tran_order_line_no               varchar(32)       null comment '交易订单行号',
    item_type                        tinyint unsigned  not null comment '项目类型（0部件，1整机2:网络成品,3:网络原材料,4:整机柜）',
    inventory_space                  varchar(32)       not null comment '库存空间（0默认库位）',
    inventory_batch                  varchar(32)       not null comment '库存批次',
    target_inventory_category_id     bigint unsigned   null comment '目标库存分类表ID',
    target_inventory_category_sub_id bigint unsigned   null comment '目标库存分类子库表ID',
    target_inventory_space           varchar(32)       null comment '目标库存空间（0默认库位）',
    target_inventory_batch           varchar(32)       null comment '目标库存批次',
    tran_entity_id                   bigint unsigned   null comment '交易实体ID',
    tran_entity_name                 varchar(32)       null comment '交易实体名称',
    seq                              int unsigned      not null comment '同笔流水内的序号',
    quantity_type                    tinyint unsigned  not null comment '标记(0出,1入,2冻结,3解冻)',
    upper_order_no                   varchar(64)       null comment '上游单据号',
    detail_status                    tinyint default 0 not null comment '状态(0:正常,1:被取消）',
    item_num                         varchar(256)      null comment '物料编码',
    feature                          json              null comment '扩展属性'
)
    comment '交易明细表' charset = utf8mb4;

create index idx_detail_status
    on tran_detail (detail_status);

create index idx_inventory_category_id
    on tran_detail (inventory_category_id);

create index idx_inventory_category_sub_id
    on tran_detail (inventory_category_sub_id);

create index idx_tran_date
    on tran_detail (tran_date);

create index idx_tran_order_no
    on tran_detail (tran_order_no);

create index idx_tran_seq_no_detail_status
    on tran_detail (tran_seq_no, detail_status);

create index idx_upper_order_no_detail_status
    on tran_detail (upper_order_no, detail_status);

create index idx_upper_order_no_seq_no
    on tran_detail (upper_order_no, tran_seq_no);

create table tran_param_log
(
    id                bigint unsigned auto_increment comment '主键'
        primary key,
    tran_seq_no       varchar(100)     not null comment '交易流水号',
    channel_system_no varchar(64)      not null comment '系统编号',
    tran_date         datetime         not null comment '交易日期',
    remark            text             null comment '备注',
    trace_id          varchar(32)      null comment 'traceId',
    error_type        tinyint unsigned null comment '错误类型',
    error_msg         varchar(1024)    null comment '错误描述',
    business_code     varchar(32)      not null comment '业务编码',
    request_param     varchar(2048)    not null comment '请求参数',
    tran_order_no     varchar(64)      not null comment '交易单据',
    upper_order_no    varchar(64)      null comment '上游单据',
    gmt_modified      datetime         not null comment '修改时间',
    gmt_create        datetime         not null comment '创建时间',
    created_by        varchar(16)      not null comment '创建人',
    modified_by       varchar(16)      not null comment '修改人'
)
    comment '对外开放接口新表' charset = utf8mb4;

create index idx_error_type
    on tran_param_log (error_type);

create index idx_tran_order_no
    on tran_param_log (tran_order_no);

create index idx_tran_seq_no
    on tran_param_log (tran_seq_no);

create index idx_tran_seq_no_system
    on tran_param_log (tran_seq_no, channel_system_no);

