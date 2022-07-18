package com.khetao.tome.dto;

import java.util.*;

/**
 * 多参数列表
 * @param <T>
 */
public class MultiResponse<T> extends CodeMessageResponse {

    private static final long serialVersionUID = 1L;

    private Collection<T> data;

    public MultiResponse() {
        super();
    }

    public Collection<T> getData() {
        if (null == data) {
            return Collections.emptyList();
        }
        if (data instanceof ArrayList) {
            return (ArrayList<T>) data;
        }
        if (data instanceof HashSet) {
            return (HashSet<T>) data;
        }
        return new ArrayList<>(data);
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public static MultiResponse success() {
        MultiResponse response = new MultiResponse();
        return response;
    }

    public static <T> MultiResponse<T> success(Collection<T> data) {
        MultiResponse<T> response = success();
        response.setData(data);
        return response;
    }


}
