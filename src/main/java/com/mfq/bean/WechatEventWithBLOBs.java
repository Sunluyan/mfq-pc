package com.mfq.bean;

public class WechatEventWithBLOBs extends WechatEvent {
    private String textContent;

    private String articlesTitle;

    private String articlesDesc;

    private String articlesPicUrl;

    private String articlesUrl;

    @Override
    public String toString() {
        return "WechatEventWithBLOBs{" +
                "textContent='" + textContent + '\'' +
                ", articlesTitle='" + articlesTitle + '\'' +
                ", articlesDesc='" + articlesDesc + '\'' +
                ", articlesPicUrl='" + articlesPicUrl + '\'' +
                ", articlesUrl='" + articlesUrl + '\'' +
                '}';
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent == null ? null : textContent.trim();
    }

    public String getArticlesTitle() {
        return articlesTitle;
    }

    public void setArticlesTitle(String articlesTitle) {
        this.articlesTitle = articlesTitle == null ? null : articlesTitle.trim();
    }

    public String getArticlesDesc() {
        return articlesDesc;
    }

    public void setArticlesDesc(String articlesDesc) {
        this.articlesDesc = articlesDesc == null ? null : articlesDesc.trim();
    }

    public String getArticlesPicUrl() {
        return articlesPicUrl;
    }

    public void setArticlesPicUrl(String articlesPicUrl) {
        this.articlesPicUrl = articlesPicUrl == null ? null : articlesPicUrl.trim();
    }

    public String getArticlesUrl() {
        return articlesUrl;
    }

    public void setArticlesUrl(String articlesUrl) {
        this.articlesUrl = articlesUrl == null ? null : articlesUrl.trim();
    }
}