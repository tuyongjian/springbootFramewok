package com.tu.curdMasterAndSlave.model;

/**
 * @Auther: tuyongjian
 * @Date: 2020/1/7 11:27
 * @Description:
 */

public enum DataSourceEnum {

    MASTER("写库","master"),
    SLAVE("读库","slave");

    private String dataSourceName;

    private String dataSourceCode;

    DataSourceEnum(String dataSourceName, String dataSourceCode) {
        this.dataSourceName = dataSourceName;
        this.dataSourceCode = dataSourceCode;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public String getDataSourceCode() {
        return dataSourceCode;
    }

    public void setDataSourceCode(String dataSourceCode) {
        this.dataSourceCode = dataSourceCode;
    }}
