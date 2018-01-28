package com.khairy.moham.drug;

/**
 * Created by moham on 1/24/2018.
 */

public interface ResponseInterface {
    interface SuccessFail {
        void failed(String errrorMsg);

        void success();
    }
}
