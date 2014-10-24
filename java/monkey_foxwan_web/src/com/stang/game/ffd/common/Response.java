package com.stang.game.ffd.common;


import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 与数据层访问后返回的对象
 * */
public class Response {

    private String returnString;
    private int returnInt;
    private boolean returnBoolean;
    private double returnDouble;
    private float returnFloat;
    private long returnLong;
    private short returnShort;
    private Date returnDate;
    private String returnCode = new String(); //操作结果代码
    private String returnMessage = new String(); //操作结果消息
    private Object returnObject;

    /**
     * @return Returns the parameters.
     */
    public Object getReturnObject() {
        return returnObject;
    }

    /**
     * @param parameters The parameters to set.
     */
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    /**
     * @return Returns the returnBoolean.
     */
    public boolean isReturnBoolean() {
        return returnBoolean;
    }

    /**
     * @param returnBoolean The returnBoolean to set.
     */
    public void setReturnBoolean(boolean returnBoolean) {
        this.returnBoolean = returnBoolean;
    }

    /**
     * @return Returns the returnCode.
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * @param returnCode The returnCode to set.
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * @return Returns the returnDate.
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate The returnDate to set.
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return Returns the returnDouble.
     */
    public double getReturnDouble() {
        return returnDouble;
    }

    /**
     * @param returnDouble The returnDouble to set.
     */
    public void setReturnDouble(double returnDouble) {
        this.returnDouble = returnDouble;
    }

    /**
     * @return Returns the returnFloat.
     */
    public float getReturnFloat() {
        return returnFloat;
    }

    /**
     * @param returnFloat The returnFloat to set.
     */
    public void setReturnFloat(float returnFloat) {
        this.returnFloat = returnFloat;
    }

    /**
     * @return Returns the returnInt.
     */
    public int getReturnInt() {
        return returnInt;
    }

    /**
     * @param returnInt The returnInt to set.
     */
    public void setReturnInt(int returnInt) {
        this.returnInt = returnInt;
    }

    /**
     * @return Returns the returnLong.
     */
    public long getReturnLong() {
        return returnLong;
    }

    /**
     * @param returnLong The returnLong to set.
     */
    public void setReturnLong(long returnLong) {
        this.returnLong = returnLong;
    }

    /**
     * @return Returns the returnMessage.
     */
    public String getReturnMessage() {
        //System.out.println("resutnMessage = " + returnMessage);
        return returnMessage;
    }

    /**
     * @param returnMessage The returnMessage to set.
     */
    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    /**
     * @return Returns the returnShort.
     */
    public short getReturnShort() {
        return returnShort;
    }

    /**
     * @param returnShort The returnShort to set.
     */
    public void setReturnShort(short returnShort) {
        this.returnShort = returnShort;
    }

    /**
     * @return Returns the returnString.
     */
    public String getReturnString() {
        return returnString;
    }

    /**
     * @param returnString The returnString to set.
     */
    public void setReturnString(String returnString) {
        this.returnString = returnString;
    }
}
