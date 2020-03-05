package com.example.demo4.utils;

public class StatusConstants {

	/**
	 * 系統默認用戶名
	 * @Value {@value}
	 */
	public static final String SYS_USER = "SYS";
	
	/**
	 * 未登錄
	 * @Value {@value}
	 */
	public static final String NO_LOGIN = "NO_LOGIN";
	
    /**
     * 请求成功
	 * @Value {@value}
     */
    public static final String SUCCESS = "200";
    /**
     * 请求失败
	 * @Value {@value}
     */
    public static final String FAILED = "000";

    /**
     * 参数空
     * @Value {@value}
     */
    public static final String PARAMS_EMPTY = "400";
    /**
     * 参数错误
	 * @Value {@value}
     */
    public static final String PARAMS_ERR = "401";
    /**
     * 未授權
	 * @Value {@value}
     **/
    public static final String UNAUTHORIZED = "402";
	/**
	 * 版本不匹配
	 * @Value {@value}
	 */
	public static final String OUTDATE = "426";
    /**
     * 服務器超時無響應
	 * @Value {@value}
     **/
    public static final String TIME_OUT = "504";
    
    /**
     * 服務器超時無響應
     * @Value {@value}
     **/
    public static final String UNTREATED = "untreated";

    /**
     * 数据重复
	 * @Value {@value}
     */
    public static final String DATA_DUPLICATE = "402" ;
    /**
     * API不匹配
	 * @Value {@value}
     **/
    public static final String API_MISMATCH = "410";


    /**
     * 无查询结果
	 * @Value {@value}
     */
    public static final String NONE_RES = "404";


    /**
     * 无效
	 * @Value {@value}
     */
    public static final String INVALID = "0";
    /**
     * 有效
	 * @Value {@value}
     */
    public static final String VALID = "1";
    /**
     * 工具失效
	 * @Value {@value}
     */
    public static final String TOOL_INVALID = "300";

    //-----请求返回数据中type标识
    /**
     * 设备标识
	 * @Value {@value}
     */
    public static final String TYPE_EQU = "1";
    /**
     * 刀柄标识
	 * @Value {@value}
     */
    public static final String TYPE_HANDLE = "2";
    /**
     * 刀具标识
	 * @Value {@value}
     */
    public static final String TYPE_TOOL = "3";
    /**
     * 故障知识库标识
     * @Value {@value}
     */
    public static final String TYPE_FAULT = "fault";
    /**
     * 用户标识
     * @Value {@value}
     */
    public static final String TYPE_USER = "user";
    /**
     * 點檢or保養表示
     * @Value {@value}
     */
    public static final String TYPE_INSP_MTNCE = "TYPE_INSP_MTNCE";
    /**
     * 設備評級
     * @Value {@value}
     */
    public static final String TYPE_EQU_RATE = "TYPE_EQU_RATE";

    
    /**
     * 搶單標識
	 * @Value {@value}
     */
    public static final String GRAB_BILL = "1";
    /**
     * 派單標識
	 * @Value {@value}
     */
    public static final String DISTRIBUTE_BILL = "2";
    
	/**
	 * 外部轉交
	 * @Value {@value}
	 */
	public static final String GIVEUP = "A";
	/**
	 * 協助
	 * @Value {@value}
	 */
	public static final String ASSIST = "B";
	/**
	 * 內部交接
	 * @Value {@value}
	 */
	public static final String HANDOVER = "C";

	//工單確認狀態碼
	/**
	 * 待作業
	 * @Value {@value}
	 */
	public static final String C_WAITOPT = "0";
	/**
	 * 通過
	 * @Value {@value}
	 */
	public static final String C_THROUGH = "1";
	/**
	 * 駁回
	 * @Value {@value}
	 */
	public static final String C_REFUSE = "2";
	
	//工程師類型
	/**
	 * 初始人員
	 * @Value {@value}
	 */
	public static final String EMP_ORIGIN = "0";
	/**
	 * 協助人員
	 * @Value {@value}
	 */
	public static final String EMP_HELP = "1";
	/**
	 * 外部转交人员
	 * @Value {@value}
	 */
	public static final String EMP_OUTER = "2";
	/**
	 *内部交接人员
	 * @Value {@value}
	 */
	public static final String EMP_INNER = "3";
	
	//工單狀態
	/**
	 *工單待指派
	 * @Value {@value}
	 */
	public static final String B_WAIT_RECEIVE = "0";
	/**
	 *維修中……
	 * @Value {@value}
	 */
	public static final String B_REPAIRING = "4";
	/**
	 *維修完成
	 * @Value {@value}
	 */
	public static final String B_COMPLETE_REPAIR = "5";
	/**
	 *產品驗收完成
	 * @Value {@value}
	 */
	public static final String B_COMPLETE_ACCEPT = "6";
	/**
	 *策略录入完成,审核中……
	 * @Value {@value}
	 */
	public static final String B_STRATERY_CHECKING = "9";
	/**
	 *策略录入完成,駁回修改中……
	 * @Value {@value}
	 */
	public static final String B_STRATERY_REFUSE = "10";
	/**
	 *維修完成-工單完成
	 * @Value {@value}
	 */
	public static final String B_COMPLETE_BILL = "7";
	/**
	 *轉交外部-工單完成
	 * @Value {@value}
	 */
	public static final String B_V_COMPLETE_BILL = "8";
	
	/**
	 *點檢
	 * @Value {@value}
	 */
	public static final String INSPECTION = "1";
	
	/**
	 *保養
	 * @Value {@value}
	 */
	public static final String MAINTENANCE = "2";

	/**
	 *作業完畢(設備點檢/保養任務)
	 * @Value {@value}
	 */
	public static final String EQUTASK_COMPLETE = "1";
	
	/**
	 *未作業(設備點檢/保養任務)
	 * @Value {@value}
	 */
	public static final String EQUTASK_UNTREATED = "0";
	
}
