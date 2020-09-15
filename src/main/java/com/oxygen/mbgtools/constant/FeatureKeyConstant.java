package com.oxygen.mbgtools.constant;


/**
 * 扩展字段属性
 * @author oxygen
 * @date 2020/7/9
 **/
public class FeatureKeyConstant {

    public static final String FEATURE = "feature";

    public static final String FEATURE_MPN_INFO = "Info";

    public static final String FEATURE_JSON_SQL = "$.";


    /**
     *
     */
    public static enum FeatureMap{
        NUMBER("order","order");
        private String index;
        private String name;

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        FeatureMap(String index,String name){
            this.index = index;
            this.name = name;
        }
    }
}
