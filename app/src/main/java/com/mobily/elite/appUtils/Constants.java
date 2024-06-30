package com.mobily.elite.appUtils;




import com.mobily.elite.R;

import java.util.ArrayList;

public class Constants {

    public static final String PROJECT_ID = "Project_id";
    public static final String PROJECT_NAME2 = "Project_name";
    public static   int SPLASH_DISPLAY_TIME = 3000;


    //LANGUAGE
    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANGUAGE_ARABIC = "ar";

    public static final String KEY_UPDATE = "key_update";
    public static final String KEY_PARCELABLE = "key_parcelable";
    public static final String POSITION = "position";
    public static final String KEY_ID = "key_id";
    public static final String AMOUNT = "amount";

    public static final int PICK_IMAGE = 9544;
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 9515;

    //RequestsCodes
    public static int FILE_TYPE_IMAGE = 1001;
    public static int FILE_TYPE_PDF = 1002;
    public static int FILE_TYPE_AUDIO = 1003;


   // public static final int SUCCESS = 1;

    //RequestsCodeServices
    public static final int SUCCESS = 200;
    public static final int error = 404;
    public static final int Failed = 401;
    public static final int Not_Authorization = 403;
    public static final int Not_Found = 404;


    public static final int CONTAINER_BASE_ACTIVITY_ID = R.id.cl_base_activity_fragment_container;
    public static final int CONTAINER_MAIN_ACTIVITY_ID = R.id.host_fragment;

    public static final String INTENT_PAGE = "fragment_name" ;
    public static final String INTENT_BUNDLE = "bundle_name" ;
    public static final String phone_Number = "phoneNumber" ;
    public static final String TOKEN = "token" ;



    public static final String ARABIC = "ar";
    public static final String ENGLISH = "en";


    public static final String INTENT_TAB_POSITION = "intent_tab_position";


    public static final String LOGIN_SUCCESS = "login_success";
    public static final String LOGIN_FAILED = "login_failed";
     public static final String REGISTER_SUCCESS = "register_success";
    public static final String REGISTER_FAILED = "register_failed";

    public static final String NETWORK_CONNECTION_ERROR = "no_internet";
    public static final String FORGET_PASS_SUCCESS = "forget_pass_success";
    public static final String FORGET_PASS_FAILED = "forget_pass_failed";
    public static final String CONFIRM_PASS_SUCCESS = "confirm_pass_success";
    public static final String CONFIRM_PASS_FAILED = "confirm_pass_failed";
    public static final String VerifyCode_PASS_FAILED = "VerifyCode_pass_failed";
    public static final String VerifyCode_PASS_SUCCESS = "VerifyCode_pass_success";

    public static final String PROJECT_NAME = "project_name";
    public static final String REPORT_NAME = "report_name";
    public static final String REPORT_TYPE = "report_type";

    public static final String REPORT_PRODUCTS = "report_products";
    public static final String REPORT_PAYS = "report_pays";

    public static final String LAT_LNG = "latlong";


    public static final String UNKNOWN_ERROR = "unknown_error";


    public static final int LOGIN_PAGE = 5;
    public static final int HOME_PAGE = 7;
    public static final int PROJECT_DETAILS_PAGE = 9;
    public static final int VERIFY_CODE_PAGE = 10;
    public static final int FORGET_PASSWORD_PAGE = 11;
    public static final int CONFIRM_PASSWORD_PAGE = 12;
    public static final int REGISTER_PAGE = 13;


    public static final String VIEW_SUCCESS = "view_success";
    public static final String VIEW_FAILED = "view_failed";

    public static final String VIEW_SUCCESS_Order = "view_success_Order";
    public static final String VIEW_FAILED_Order = "view_failed_Order";

    public static final String VIEW_NOT_Authorization = "view_authoize";
    public static final String VIEW_NOT_FOUND = "view_found";
    public static final String DT_SUCCESS = "success";
    public static final String DAT_FAILED = "failed";
    public static final String DATA_Authorization = "authoize";
    public static final String DATA_FOUND = "found";
    public static final String DATA_SUCCESS = "data_success";
    public static final String DATA_FAILED = "data_failed";
    public static final String DATA_NOT_Authorization = "data_authoize";
    public static final String DATA_NOT_FOUND = "data_found";

    public static final String DATA_SUCCESSName = "data_success_Name";
    public static final String DATA_FAILEDName = "data_failed_Name";
    public static final String DATA_NOT_AuthorizationName = "data_authoize_Name";
    public static final String DATA_NOT_FOUNDName = "data_found_Name";

    public static final String EDIT_PROFILE_SUCCESS = "edit_profile_success";
    public static final String EDIT_PROFILE_FAILED = "edit_profile_failed";
    public static final String EDIT_PROFILE_NOT_AUTHORIZATION = "edit_profile_not_authorization";
    public static final String EDIT_PROFILE_NOT_FOUND = "edit_profile_not_found";

    public static final String COUNT_SUCCESS = "count_success";
    public static final String COUNT_FAILED = "count_failed";
    public static final String COUNT_NOT_Authorization = "count_authoize";
    public static final String COUNT_NOT_FOUND = "count_found";

    public static final String CATEGORY_NAME = "category_name";
    public static final String CATEGORY_ID = "category_id";
    public static final String CATEGORY_Position = "category_position";
    public static final String ORDER_ID = "order_id";
    public static final String ORDER_Name = "order_name";
    public static final String ORDER_Wallet = "order_totalWallet";

    public static final String SUB_CATEGORY_NAME = "sub_category_name";
    public static final String SUB_CATEGORY_ID = "sub_category_id";

    public static final String DELETE_SUCCESS = "delete_success";
    public static final String DELETE_FAILED = "delete_failed";
    public static final String DELETE_NOT_AUTHOIZE = "delete_authoize";
    public static final String DELETE_NOT_FOUND = "delete_found";

    public static final String INBOX_ID = "inbox_id";
    public static final String INBOX_TYPE = "inbox_type";
    public static final String ORDER_TYPE = "order_type";
    public static final String OBJECT = "object";


    public static final String UPLOAD_SUCCESS = "upload_success";
    public static final String UPLOAD_FAILED = "upload_failed";
    public static final String UPLOAD_NOT_AUTHOIZE = "upload_authoize";
    public static final String UPLOAD_NOT_FOUND = "upload_found";


    public static final String PROJECT_WALLET = "project_wallet";
    public static final String TOTAL_PRICE = "total_price";
    public static final String ORDER_ID_PAYMENT = "order_id_payment";


    public static final String HAS_DELIGATE = "has_deligate";
    public static final String DELIVERY_CODE = "delivery_code";
    public static final String  DELIGATE_NAME = "deligate_name";
    public static final String  DELIGATE_PHONE = "deligate_phone";

    public static final String  latitude = "LATITUDE";
    public static final String  longtidue = "LONGTIDUE";

    public static final String  PAYS_From = "pays_from";
    public static final String  PAYS_To= "pays_to";

    public static final String ORDER_ITEM = "order_item";
    public final static ArrayList<Float> densities = new ArrayList<Float>() {
        {
            add(0.75f);
            add(1.0f);
            add(1.5f);
            add(2.0f);
            add(3.0f);
            add(4.0f);
        }
    };

}
