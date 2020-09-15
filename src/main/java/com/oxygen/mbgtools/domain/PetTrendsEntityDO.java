package com.oxygen.mbgtools.domain;

import com.oxygen.mbgtools.mybatis.bean.BaseBean;
import java.time.LocalDateTime;

public class PetTrendsEntityDO extends BaseBean {
    /**
     * 自增序列号
     * 表字段 : pet_trends_entity.id
     */
    private Long id;

    /**
     * 动态标题
     * 表字段 : pet_trends_entity.title
     */
    private String title;

    /**
     * 宠物动态内容
     * 表字段 : pet_trends_entity.content
     */
    private String content;

    /**
     * 发布人客户号
     * 表字段 : pet_trends_entity.user_id
     */
    private Long userId;

    /**
     * 省份
     * 表字段 : pet_trends_entity.province
     */
    private String province;

    /**
     * 城市
     * 表字段 : pet_trends_entity.city
     */
    private String city;

    /**
     * 区/县/州
     * 表字段 : pet_trends_entity.area
     */
    private String area;

    /**
     * 详细地址
     * 表字段 : pet_trends_entity.address
     */
    private String address;

    /**
     * 图片数组
     * 表字段 : pet_trends_entity.img_arry
     */
    private String imgArry;

    /**
     * 视频路径数组
     * 表字段 : pet_trends_entity.video_arry
     */
    private String videoArry;

    /**
     * 文件类型( 1-图片 2-视频)
     * 表字段 : pet_trends_entity.file_type
     */
    private Byte fileType;

    /**
     * 经度
     * 表字段 : pet_trends_entity.longitude
     */
    private Double longitude;

    /**
     * 维度
     * 表字段 : pet_trends_entity.latitude
     */
    private Double latitude;

    /**
     * 经纬度
     * 表字段 : pet_trends_entity.locs
     */
    private String locs;

    /**
     * 动态类型
     * 表字段 : pet_trends_entity.type
     */
    private Boolean type;

    /**
     * 1-猫  2-狗 3-猫狗随意  
     * 表字段 : pet_trends_entity.like_pet_type
     */
    private Boolean likePetType;

    /**
     * 流程状态 0-流程未走完 1-流程走完
     * 表字段 : pet_trends_entity.status
     */
    private Boolean status;

    /**
     * 分享次数
     * 表字段 : pet_trends_entity.share_count
     */
    private Integer shareCount;

    /**
     * 
     * 表字段 : pet_trends_entity.head_pcI_mg_url
     */
    private String headPciMgUrl;

    /**
     * 昵称
     * 表字段 : pet_trends_entity.nick_mame
     */
    private String nickMame;

    /**
     * 手机号
     * 表字段 : pet_trends_entity.mobile
     */
    private String mobile;

    /**
     * 签名
     * 表字段 : pet_trends_entity.sign_name
     */
    private String signName;

    /**
     * 距离
     * 表字段 : pet_trends_entity.distance
     */
    private Double distance;

    /**
     * 点赞状态 0-已经点赞 1-未点赞
     * 表字段 : pet_trends_entity.upvote_status
     */
    private Boolean upvoteStatus;

    /**
     * 关注状态
     * 表字段 : pet_trends_entity.follow_status
     */
    private Byte followStatus;

    /**
     * 评论次数
     * 表字段 : pet_trends_entity.comment_count
     */
    private Integer commentCount;

    /**
     * 0、下线，1、上线
     * 表字段 : pet_trends_entity.state
     */
    private Boolean state;

    /**
     * 审核状态（0、待发布,1、申请审核，2、审核通过，3、审核失败）
     * 表字段 : pet_trends_entity.audit_status
     */
    private Byte auditStatus;

    /**
     * 审核失败原因
     * 表字段 : pet_trends_entity.audit_reason
     */
    private String auditReason;

    /**
     * 下线原因
     * 表字段 : pet_trends_entity.down_reason
     */
    private String downReason;

    /**
     * 点赞次数
     * 表字段 : pet_trends_entity.zan_count
     */
    private Integer zanCount;

    /**
     * 领养人ID
     * 表字段 : pet_trends_entity.adopter_id
     */
    private Long adopterId;

    /**
     * 申请领养人数量
     * 表字段 : pet_trends_entity.applicate_count
     */
    private Integer applicateCount;

    /**
     * 当前用户申请状态
     * 表字段 : pet_trends_entity.apply_adopt_status
     */
    private Boolean applyAdoptStatus;

    /**
     * 创建时间
     * 表字段 : pet_trends_entity.create_time
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     * 表字段 : pet_trends_entity.update_time
     */
    private LocalDateTime updateTime;

    /**
     * 原用户ID
     * 表字段 : pet_trends_entity.o_user_id
     */
    private String oUserId;

    /**
     * 获取 自增序列号 字段:pet_trends_entity.id
     *
     * @return pet_trends_entity.id, 自增序列号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增序列号 字段:pet_trends_entity.id
     *
     * @param id the value for pet_trends_entity.id, 自增序列号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 动态标题 字段:pet_trends_entity.title
     *
     * @return pet_trends_entity.title, 动态标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 动态标题 字段:pet_trends_entity.title
     *
     * @param title the value for pet_trends_entity.title, 动态标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 宠物动态内容 字段:pet_trends_entity.content
     *
     * @return pet_trends_entity.content, 宠物动态内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 宠物动态内容 字段:pet_trends_entity.content
     *
     * @param content the value for pet_trends_entity.content, 宠物动态内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取 发布人客户号 字段:pet_trends_entity.user_id
     *
     * @return pet_trends_entity.user_id, 发布人客户号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 发布人客户号 字段:pet_trends_entity.user_id
     *
     * @param userId the value for pet_trends_entity.user_id, 发布人客户号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 省份 字段:pet_trends_entity.province
     *
     * @return pet_trends_entity.province, 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置 省份 字段:pet_trends_entity.province
     *
     * @param province the value for pet_trends_entity.province, 省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取 城市 字段:pet_trends_entity.city
     *
     * @return pet_trends_entity.city, 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置 城市 字段:pet_trends_entity.city
     *
     * @param city the value for pet_trends_entity.city, 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取 区/县/州 字段:pet_trends_entity.area
     *
     * @return pet_trends_entity.area, 区/县/州
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置 区/县/州 字段:pet_trends_entity.area
     *
     * @param area the value for pet_trends_entity.area, 区/县/州
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取 详细地址 字段:pet_trends_entity.address
     *
     * @return pet_trends_entity.address, 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 详细地址 字段:pet_trends_entity.address
     *
     * @param address the value for pet_trends_entity.address, 详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取 图片数组 字段:pet_trends_entity.img_arry
     *
     * @return pet_trends_entity.img_arry, 图片数组
     */
    public String getImgArry() {
        return imgArry;
    }

    /**
     * 设置 图片数组 字段:pet_trends_entity.img_arry
     *
     * @param imgArry the value for pet_trends_entity.img_arry, 图片数组
     */
    public void setImgArry(String imgArry) {
        this.imgArry = imgArry == null ? null : imgArry.trim();
    }

    /**
     * 获取 视频路径数组 字段:pet_trends_entity.video_arry
     *
     * @return pet_trends_entity.video_arry, 视频路径数组
     */
    public String getVideoArry() {
        return videoArry;
    }

    /**
     * 设置 视频路径数组 字段:pet_trends_entity.video_arry
     *
     * @param videoArry the value for pet_trends_entity.video_arry, 视频路径数组
     */
    public void setVideoArry(String videoArry) {
        this.videoArry = videoArry == null ? null : videoArry.trim();
    }

    /**
     * 获取 文件类型( 1-图片 2-视频) 字段:pet_trends_entity.file_type
     *
     * @return pet_trends_entity.file_type, 文件类型( 1-图片 2-视频)
     */
    public Byte getFileType() {
        return fileType;
    }

    /**
     * 设置 文件类型( 1-图片 2-视频) 字段:pet_trends_entity.file_type
     *
     * @param fileType the value for pet_trends_entity.file_type, 文件类型( 1-图片 2-视频)
     */
    public void setFileType(Byte fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取 经度 字段:pet_trends_entity.longitude
     *
     * @return pet_trends_entity.longitude, 经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 设置 经度 字段:pet_trends_entity.longitude
     *
     * @param longitude the value for pet_trends_entity.longitude, 经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取 维度 字段:pet_trends_entity.latitude
     *
     * @return pet_trends_entity.latitude, 维度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 设置 维度 字段:pet_trends_entity.latitude
     *
     * @param latitude the value for pet_trends_entity.latitude, 维度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取 经纬度 字段:pet_trends_entity.locs
     *
     * @return pet_trends_entity.locs, 经纬度
     */
    public String getLocs() {
        return locs;
    }

    /**
     * 设置 经纬度 字段:pet_trends_entity.locs
     *
     * @param locs the value for pet_trends_entity.locs, 经纬度
     */
    public void setLocs(String locs) {
        this.locs = locs == null ? null : locs.trim();
    }

    /**
     * 获取 动态类型 字段:pet_trends_entity.type
     *
     * @return pet_trends_entity.type, 动态类型
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置 动态类型 字段:pet_trends_entity.type
     *
     * @param type the value for pet_trends_entity.type, 动态类型
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取 1-猫  2-狗 3-猫狗随意   字段:pet_trends_entity.like_pet_type
     *
     * @return pet_trends_entity.like_pet_type, 1-猫  2-狗 3-猫狗随意  
     */
    public Boolean getLikePetType() {
        return likePetType;
    }

    /**
     * 设置 1-猫  2-狗 3-猫狗随意   字段:pet_trends_entity.like_pet_type
     *
     * @param likePetType the value for pet_trends_entity.like_pet_type, 1-猫  2-狗 3-猫狗随意  
     */
    public void setLikePetType(Boolean likePetType) {
        this.likePetType = likePetType;
    }

    /**
     * 获取 流程状态 0-流程未走完 1-流程走完 字段:pet_trends_entity.status
     *
     * @return pet_trends_entity.status, 流程状态 0-流程未走完 1-流程走完
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置 流程状态 0-流程未走完 1-流程走完 字段:pet_trends_entity.status
     *
     * @param status the value for pet_trends_entity.status, 流程状态 0-流程未走完 1-流程走完
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取 分享次数 字段:pet_trends_entity.share_count
     *
     * @return pet_trends_entity.share_count, 分享次数
     */
    public Integer getShareCount() {
        return shareCount;
    }

    /**
     * 设置 分享次数 字段:pet_trends_entity.share_count
     *
     * @param shareCount the value for pet_trends_entity.share_count, 分享次数
     */
    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    /**
     * 获取  字段:pet_trends_entity.head_pcI_mg_url
     *
     * @return pet_trends_entity.head_pcI_mg_url, 
     */
    public String getHeadPciMgUrl() {
        return headPciMgUrl;
    }

    /**
     * 设置  字段:pet_trends_entity.head_pcI_mg_url
     *
     * @param headPciMgUrl the value for pet_trends_entity.head_pcI_mg_url, 
     */
    public void setHeadPciMgUrl(String headPciMgUrl) {
        this.headPciMgUrl = headPciMgUrl == null ? null : headPciMgUrl.trim();
    }

    /**
     * 获取 昵称 字段:pet_trends_entity.nick_mame
     *
     * @return pet_trends_entity.nick_mame, 昵称
     */
    public String getNickMame() {
        return nickMame;
    }

    /**
     * 设置 昵称 字段:pet_trends_entity.nick_mame
     *
     * @param nickMame the value for pet_trends_entity.nick_mame, 昵称
     */
    public void setNickMame(String nickMame) {
        this.nickMame = nickMame == null ? null : nickMame.trim();
    }

    /**
     * 获取 手机号 字段:pet_trends_entity.mobile
     *
     * @return pet_trends_entity.mobile, 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置 手机号 字段:pet_trends_entity.mobile
     *
     * @param mobile the value for pet_trends_entity.mobile, 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取 签名 字段:pet_trends_entity.sign_name
     *
     * @return pet_trends_entity.sign_name, 签名
     */
    public String getSignName() {
        return signName;
    }

    /**
     * 设置 签名 字段:pet_trends_entity.sign_name
     *
     * @param signName the value for pet_trends_entity.sign_name, 签名
     */
    public void setSignName(String signName) {
        this.signName = signName == null ? null : signName.trim();
    }

    /**
     * 获取 距离 字段:pet_trends_entity.distance
     *
     * @return pet_trends_entity.distance, 距离
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * 设置 距离 字段:pet_trends_entity.distance
     *
     * @param distance the value for pet_trends_entity.distance, 距离
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * 获取 点赞状态 0-已经点赞 1-未点赞 字段:pet_trends_entity.upvote_status
     *
     * @return pet_trends_entity.upvote_status, 点赞状态 0-已经点赞 1-未点赞
     */
    public Boolean getUpvoteStatus() {
        return upvoteStatus;
    }

    /**
     * 设置 点赞状态 0-已经点赞 1-未点赞 字段:pet_trends_entity.upvote_status
     *
     * @param upvoteStatus the value for pet_trends_entity.upvote_status, 点赞状态 0-已经点赞 1-未点赞
     */
    public void setUpvoteStatus(Boolean upvoteStatus) {
        this.upvoteStatus = upvoteStatus;
    }

    /**
     * 获取 关注状态 字段:pet_trends_entity.follow_status
     *
     * @return pet_trends_entity.follow_status, 关注状态
     */
    public Byte getFollowStatus() {
        return followStatus;
    }

    /**
     * 设置 关注状态 字段:pet_trends_entity.follow_status
     *
     * @param followStatus the value for pet_trends_entity.follow_status, 关注状态
     */
    public void setFollowStatus(Byte followStatus) {
        this.followStatus = followStatus;
    }

    /**
     * 获取 评论次数 字段:pet_trends_entity.comment_count
     *
     * @return pet_trends_entity.comment_count, 评论次数
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 设置 评论次数 字段:pet_trends_entity.comment_count
     *
     * @param commentCount the value for pet_trends_entity.comment_count, 评论次数
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 获取 0、下线，1、上线 字段:pet_trends_entity.state
     *
     * @return pet_trends_entity.state, 0、下线，1、上线
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置 0、下线，1、上线 字段:pet_trends_entity.state
     *
     * @param state the value for pet_trends_entity.state, 0、下线，1、上线
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * 获取 审核状态（0、待发布,1、申请审核，2、审核通过，3、审核失败） 字段:pet_trends_entity.audit_status
     *
     * @return pet_trends_entity.audit_status, 审核状态（0、待发布,1、申请审核，2、审核通过，3、审核失败）
     */
    public Byte getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置 审核状态（0、待发布,1、申请审核，2、审核通过，3、审核失败） 字段:pet_trends_entity.audit_status
     *
     * @param auditStatus the value for pet_trends_entity.audit_status, 审核状态（0、待发布,1、申请审核，2、审核通过，3、审核失败）
     */
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取 审核失败原因 字段:pet_trends_entity.audit_reason
     *
     * @return pet_trends_entity.audit_reason, 审核失败原因
     */
    public String getAuditReason() {
        return auditReason;
    }

    /**
     * 设置 审核失败原因 字段:pet_trends_entity.audit_reason
     *
     * @param auditReason the value for pet_trends_entity.audit_reason, 审核失败原因
     */
    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason == null ? null : auditReason.trim();
    }

    /**
     * 获取 下线原因 字段:pet_trends_entity.down_reason
     *
     * @return pet_trends_entity.down_reason, 下线原因
     */
    public String getDownReason() {
        return downReason;
    }

    /**
     * 设置 下线原因 字段:pet_trends_entity.down_reason
     *
     * @param downReason the value for pet_trends_entity.down_reason, 下线原因
     */
    public void setDownReason(String downReason) {
        this.downReason = downReason == null ? null : downReason.trim();
    }

    /**
     * 获取 点赞次数 字段:pet_trends_entity.zan_count
     *
     * @return pet_trends_entity.zan_count, 点赞次数
     */
    public Integer getZanCount() {
        return zanCount;
    }

    /**
     * 设置 点赞次数 字段:pet_trends_entity.zan_count
     *
     * @param zanCount the value for pet_trends_entity.zan_count, 点赞次数
     */
    public void setZanCount(Integer zanCount) {
        this.zanCount = zanCount;
    }

    /**
     * 获取 领养人ID 字段:pet_trends_entity.adopter_id
     *
     * @return pet_trends_entity.adopter_id, 领养人ID
     */
    public Long getAdopterId() {
        return adopterId;
    }

    /**
     * 设置 领养人ID 字段:pet_trends_entity.adopter_id
     *
     * @param adopterId the value for pet_trends_entity.adopter_id, 领养人ID
     */
    public void setAdopterId(Long adopterId) {
        this.adopterId = adopterId;
    }

    /**
     * 获取 申请领养人数量 字段:pet_trends_entity.applicate_count
     *
     * @return pet_trends_entity.applicate_count, 申请领养人数量
     */
    public Integer getApplicateCount() {
        return applicateCount;
    }

    /**
     * 设置 申请领养人数量 字段:pet_trends_entity.applicate_count
     *
     * @param applicateCount the value for pet_trends_entity.applicate_count, 申请领养人数量
     */
    public void setApplicateCount(Integer applicateCount) {
        this.applicateCount = applicateCount;
    }

    /**
     * 获取 当前用户申请状态 字段:pet_trends_entity.apply_adopt_status
     *
     * @return pet_trends_entity.apply_adopt_status, 当前用户申请状态
     */
    public Boolean getApplyAdoptStatus() {
        return applyAdoptStatus;
    }

    /**
     * 设置 当前用户申请状态 字段:pet_trends_entity.apply_adopt_status
     *
     * @param applyAdoptStatus the value for pet_trends_entity.apply_adopt_status, 当前用户申请状态
     */
    public void setApplyAdoptStatus(Boolean applyAdoptStatus) {
        this.applyAdoptStatus = applyAdoptStatus;
    }

    /**
     * 获取 创建时间 字段:pet_trends_entity.create_time
     *
     * @return pet_trends_entity.create_time, 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:pet_trends_entity.create_time
     *
     * @param createTime the value for pet_trends_entity.create_time, 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 更新时间 字段:pet_trends_entity.update_time
     *
     * @return pet_trends_entity.update_time, 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 字段:pet_trends_entity.update_time
     *
     * @param updateTime the value for pet_trends_entity.update_time, 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 原用户ID 字段:pet_trends_entity.o_user_id
     *
     * @return pet_trends_entity.o_user_id, 原用户ID
     */
    public String getoUserId() {
        return oUserId;
    }

    /**
     * 设置 原用户ID 字段:pet_trends_entity.o_user_id
     *
     * @param oUserId the value for pet_trends_entity.o_user_id, 原用户ID
     */
    public void setoUserId(String oUserId) {
        this.oUserId = oUserId == null ? null : oUserId.trim();
    }
}