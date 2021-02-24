package com.qianfeng.springboot.entity;

public class ContractProduct {
    private Integer cpId;
    private Integer contractId;
    private Integer productId;
    private Integer count;//产品数量
    private Contract contract;
    private Product product;

    public ContractProduct() {
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ContractProduct{" +
                "cpId=" + cpId +
                ", contractId=" + contractId +
                ", productId=" + productId +
                ", count=" + count +
                ", contract=" + contract +
                ", product=" + product +
                '}';
    }
}
