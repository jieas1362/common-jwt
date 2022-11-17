package com.future.jwt.constant;

/**
 * jwt default element
 *
 * @author liuyunfei
 */
public enum JwtDefaultElement {

    /**
     * issuer
     */
    ISSUER("Pro"),

    /**
     * subject
     */
    SUBJECT("Hello"),

    /**
     * audience
     */
    AUDIENCE("Pros");

    public final String identity;

    JwtDefaultElement(String identity) {
        this.identity = identity;
    }

}
