package cn.murphy.springbootLearning.test;

public  class ChineseNumberUtil {
    public  static  final  String ZERO = "零";
    public  static  final  String ONE = "一";
    public  static  final  String TWO = "二";
    public  static  final  String THREE = "三";
    public  static  final  String FOUR = "四";
    public  static  final  String FIVE = "五";
    public  static  final  String SIX = "六";
    public  static  final  String SEVEN = "七";
    public  static  final  String EIGHT = "八";
    public  static  final  String NINE = "九";
    public  static  final  String POINT = "点";

    // OLD CHINESE NUMBER
    public  static  final  String OLD_ONE = "壹";
    public  static  final  String OLD_TWO = "贰";
    public  static  final  String OLD_THREE = "叁";
    public  static  final  String OLD_FOUR = "肆";
    public  static  final  String OLD_FIVE = "伍";
    public  static  final  String OLD_SIX = "陆";
    public  static  final  String OLD_SEVEN = "柒";
    public  static  final  String OLD_EIGHT = "捌";
    public  static  final  String OLD_NINE = "玖";

    public  static  final  String HUNDRED = "佰";
    public  static  final  String THOUSAND = "千";
    public  static  final  String TEN_THOUSAND = "萬";
    public  static  final  String HUNDRED_THOUSAND = "十萬";
    public  static  final  String MILLION = "佰万";
    public  static  final  String TEN_MILLION = "千万";

    public  static  final  int NEW_TPYE = 0;
    public  static  final  int OLD_TPYE = 1;
    /**
     * 功能描述:
     * 〈将阿拉伯数字转换成中文数字〉
     *
     * @params : [number]
     * @return  : java.lang.String
     * @author : cwl
     * @date : 2019/10/28 10:16
     */
    public  static  String getChineseNumber(double number){
        String numStr = String.valueOf(number);
        return  handleBytes(numStr,NEW_TPYE);
    }

    /**
     * 功能描述:
     * 〈获得中文数字,指定类型〉
     *
     * @params : [number, type]
     * @return  : java.lang.String
     * @author : cwl
     * @date : 2019/10/28 16:12
     */
    public  static  String getChineseNumber(double number,int type){
        String numStr = String.valueOf(number);
        return  handleBytes(numStr,type);
    }


    /**
     * 功能描述:
     * 〈处理具体的Byte[],拼接成想要的格式〉
     *
     * @params : [bytes, sb, especially]
     * @return  : void
     * @author : cwl
     * @date : 2019/10/28 10:56
     */
    private  static  String handleBytes(String str, int type) {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = str.getBytes();
        if(NEW_TPYE == type){
            return  handelNewType(bytes,sb);
        }
        return  handleOldType(bytes,sb).toString();
    }

    /**
     * 功能描述:
     * 〈处理发票式数字〉
     *
     * @params : [bytes, sb]
     * @return  : java.lang.String
     * @author : cwl
     * @date : 2019/10/28 11:04
     */
    private  static  StringBuilder handleOldType(byte[] bytes, StringBuilder sb) {
        for (int i=0;i<bytes.length;i++) {
            switch (bytes[i]){
                case 46:
                    sb.append(POINT);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                case 48:
                    sb.append(ZERO);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                case 49:
                    sb.append(OLD_ONE);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                case 50:
                    sb.append(OLD_TWO);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                case 51:
                    sb.append(OLD_THREE);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                case 52:
                    sb.append(OLD_FOUR);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                case 53:
                    sb.append(OLD_FIVE);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                case 54:
                    sb.append(OLD_SIX);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                case 55:
                    sb.append(OLD_SEVEN);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                case 56:
                    sb.append(OLD_EIGHT);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                case 57:
                    sb.append(OLD_NINE);
                    sb = handleUnit(sb,i,bytes.length);
                    break;
                default:break;
            }
        }
        return  sb;
    }

    /**
     * 功能描述:
     * 〈处理数字单位〉
     *
     * @params : [sb, i]
     * @return  : void
     * @author : cwl
     * @date : 2019/10/28 11:57
     */
    private  static  StringBuilder handleUnit(StringBuilder sb, int i, int length) {
        if(length <= 1){
            return  sb;
        }

        switch(length){
            case 3 :
                sb = handleHundred(i,sb);
                break;
            case 4 :
                sb = handleThousand(i,sb);
                break;
            case 5 :
                sb = handleTenThousand(i,sb);
                break;
            case 6 :
                sb = handleHundredThousand(i,sb);
                break;
            case 7 :
                sb = handleMillion(i,sb);
                break;
            case 8 :
                sb = handleTenMillion(i,sb);
        }
        return  sb;
    }

    /**
     * 功能描述:
     * 〈拼接千万〉
     *
     * @params : [i, sb]
     * @return  : java.lang.StringBuilder
     * @author : cwl
     * @date : 2019/10/28 15:42
     */
    private  static  StringBuilder handleTenMillion(int i, StringBuilder sb) {
        if(i == 0){
            sb.append(TEN_MILLION);
        }
        if(i == 1){
            sb.append(MILLION);
        }
        if(i == 2){
            sb.append(HUNDRED_THOUSAND);
        }
        if(i == 3){
            sb.append(TEN_THOUSAND);
        }
        if(i == 4){
            sb.append(THOUSAND);
        }
        if(i == 5){
            sb.append(HUNDRED);
        }
        return  sb;
    }

    /**
     * 功能描述:
     * 〈拼接百万〉
     *
     * @params : [i, sb]
     * @return  : java.lang.StringBuilder
     * @author : cwl
     * @date : 2019/10/28 15:42
     */
    private  static  StringBuilder handleMillion(int i, StringBuilder sb) {
        if(i == 0){
            sb.append(MILLION);
        }
        if(i == 1){
            sb.append(HUNDRED_THOUSAND);
        }
        if(i == 2){
            sb.append(TEN_THOUSAND);
        }
        if(i == 3){
            sb.append(THOUSAND);
        }
        if(i == 4){
            sb.append(HUNDRED);
        }
        return  sb;
    }

    /**
     * 功能描述:
     * 〈拼接十万〉
     *
     * @params : [i, sb]
     * @return  : java.lang.StringBuilder
     * @author : cwl
     * @date : 2019/10/28 15:39
     */
    private  static  StringBuilder handleHundredThousand(int i, StringBuilder sb) {
        if(i == 0){
            sb.append(HUNDRED_THOUSAND);
        }
        if(i == 1){
            sb.append(TEN_THOUSAND);
        }
        if(i == 2){
            sb.append(THOUSAND);
        }
        if(i == 3){
            sb.append(HUNDRED);
        }
        return  null;
    }

    /**
     * 功能描述:
     * 〈拼接万〉
     *
     * @params : [i, sb]
     * @return  : java.lang.StringBuilder
     * @author : cwl
     * @date : 2019/10/28 15:31
     */
    private  static  StringBuilder handleTenThousand(int i, StringBuilder sb) {
        if(i == 0){
            sb.append(TEN_THOUSAND);
        }
        if(i == 1){
            sb.append(THOUSAND);
        }
        if(i == 2){
            sb.append(HUNDRED);
        }
        return  sb;
    }

    /**
     * 功能描述:
     * 〈拼接千位数〉
     *
     * @params : [i, sb]
     * @return  : java.lang.StringBuilder
     * @author : cwl
     * @date : 2019/10/28 15:30
     */
    private  static  StringBuilder handleThousand(int i, StringBuilder sb) {
        if(i == 0){
            sb.append(THOUSAND);
        }
        if(i == 1){
            sb.append(HUNDRED);
        }
        return  sb;
    }

    /**
     * 功能描述:
     * 〈拼接百位数〉
     *
     * @params : [i, sb]
     * @return  : void
     * @author : cwl
     * @date : 2019/10/28 15:28
     */
    private  static  StringBuilder handleHundred(int i, StringBuilder sb) {
        if(i == 0){
            sb.append(HUNDRED);
        }
        return  sb;
    }

    /**
     * 功能描述:
     * 〈处理简单中文数字〉
     *
     * @params : [bytes, sb]
     * @return  : void
     * @author : cwl
     * @date : 2019/10/28 11:02
     */
    private  static  String handelNewType(byte[] bytes, StringBuilder sb) {
        for (byte aByte : bytes) {
            switch (aByte){
                case 46:
                    sb.append(POINT);
                    break;
                case 48:
                    sb.append(ZERO);
                    break;
                case 49:
                    sb.append(ONE);
                    break;
                case 50:
                    sb.append(TWO);
                    break;
                case 51:
                    sb.append(THREE);
                    break;
                case 52:
                    sb.append(FOUR);
                    break;
                case 53:
                    sb.append(FIVE);
                    break;
                case 54:
                    sb.append(SIX);
                    break;
                case 55:
                    sb.append(SEVEN);
                    break;
                case 56:
                    sb.append(EIGHT);
                    break;
                case 57:
                    sb.append(NINE);
                    break;
                default:break;
            }
        }
        return  sb.toString();
    }

    /**
     * 功能描述:
     * 〈〉
     *
     * @params : [number]
     * @return  : double
     * @author : cwl
     * @date : 2019/10/28 10:38
     */
    public  static  double getNumber(String number){
        if(null == number || "".equals(number)){
            throw new RuntimeException("number is not be null or blank");
        }
        char[] chars = number.toCharArray();
        char[] everyChar;
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            everyChar = new char[1];
            everyChar[0] = aChar;
            switch (new String(everyChar)){
                case POINT :
                    sb.append(".");
                    break;
                case ZERO :
                    sb.append("0");
                    break;
                case ONE :
                    sb.append("1");
                    break;
                case TWO :
                    sb.append("2");
                    break;
                case THREE :
                    sb.append("3");
                    break;
                case FOUR :
                    sb.append("4");
                    break;
                case FIVE :
                    sb.append("5");
                    break;
                case SIX :
                    sb.append("6");
                    break;
                case SEVEN :
                    sb.append("7");
                    break;
                case EIGHT :
                    sb.append("8");
                    break;
                case NINE :
                    sb.append("9");
                    break;
                default:break;
            }
        }
        return  Double.valueOf(sb.toString());
    }

    /**
     * 功能描述:
     * 〈获得发票上的中文数字〉
     *
     * @params : [number]
     * @return  : java.lang.String
     * @author : cwl
     * @date : 2019/10/28 10:50
     */
    public  static  String getInvoiceNumber(double number){
        StringBuilder sb = new StringBuilder();
        String valueOf = String.valueOf(number);
        byte[] bytes = valueOf.getBytes();
        StringBuilder builder = new StringBuilder();
        StringBuilder builderFloat = new StringBuilder();
        for (int i=0;i<bytes.length;i++) {
            if(bytes[i] == 46){
                for (int j=i;j<bytes.length;j++) {
                    builderFloat.append(new String(new byte[]{bytes[j]}));
                }
                break;
            }
            builder.append(new String(new byte[]{bytes[i]}));
        }
        StringBuilder result = handleOldType(builder.toString().getBytes(), sb);
        StringBuilder chineseNumber = handleOldTypeIgnoreUnit(builderFloat.toString());
        result.append(chineseNumber);
        return  result.toString();
    }

    /**
     * 功能描述:
     * 〈处理老式发票抬头数字 忽略单位,仅为小数点后的数字〉
     *
     * @params : [toString]
     * @return  : java.lang.StringBuilder
     * @author : cwl
     * @date : 2019/10/28 16:22
     */
    private  static  StringBuilder handleOldTypeIgnoreUnit(String toString) {
        byte[] bytes = toString.getBytes();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<bytes.length;i++) {
            switch (bytes[i]){
                case 46:
                    sb.append(POINT);
                    break;
                case 48:
                    sb.append(ZERO);
                    break;
                case 49:
                    sb.append(OLD_ONE);
                    break;
                case 50:
                    sb.append(OLD_TWO);
                    break;
                case 51:
                    sb.append(OLD_THREE);
                    break;
                case 52:
                    sb.append(OLD_FOUR);
                    break;
                case 53:
                    sb.append(OLD_FIVE);
                    break;
                case 54:
                    sb.append(OLD_SIX);
                    break;
                case 55:
                    sb.append(OLD_SEVEN);
                    break;
                case 56:
                    sb.append(OLD_EIGHT);
                    break;
                case 57:
                    sb.append(OLD_NINE);
                    break;
                default:break;
            }
        }
        return  sb;
    }


    /*

     *基本数字单位;

     */

    private  static  final  String[]units=

            {"千","百","十",""};//个位


    /*

     *大数字单位;

     */

    private  static  final  String[]bigUnits=

            {"万","亿"};


    /*

     *中文数字;

     */

    private static final char[]numChars=

            {'一','二','三','四','五','六','七','八','九'};


//private static  final  char[] numMouneyChars =

//{ '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };


    private static char numZero='零';


    /**

     *将中文数字转换为阿拉伯数字;

     *

     *@paramnumberCN

     *@return 

     */

    public static int numberCN2Arab(String numberCN) {


        String tempNumberCN = numberCN;


//异常数据处理;

        if(tempNumberCN ==null) {

            return 0;

        }


        /*

         *nums[0]保存以千单位;nums[1]保存以万单位;nums[2]保存以亿单位;

         */

        String[] nums =new String[bigUnits.length+ 1];


//千位以内,直接处理;

        nums[0] = tempNumberCN;


        /*

         *分割大数字,以千为单位进行运算;

         */

        for(int i = (bigUnits.length- 1); i >= 0; i--) {


//是否存在大单位(万,亿...);

            int find = tempNumberCN.indexOf(bigUnits[i]);


            if(find != -1) {

                String[] tempStrs = tempNumberCN.split(bigUnits[i]);


//清空千位内容;

                if(nums[0] !=null) {

                    nums[0] =null;

                }


                if(tempStrs[0] !=null) {

                    nums[i + 1] = tempStrs[0];

                }


                if(tempStrs.length> 1) {

                    tempNumberCN = tempStrs[1];


                    if(i == 0) {

                        nums[0] = tempStrs[1];

                    }


                }else{

                    tempNumberCN =null;


                    break;

                }

            }

        }


        String tempResultNum ="";


        for(int i = nums.length- 1; i >= 0; i--) {

            if(nums[i] !=null) {

                tempResultNum +=numberKCN2Arab(nums[i]);

            }else{

                tempResultNum +="0000";

            }

        }


        return Integer.parseInt(tempResultNum);

    }


    /**

     *将一位中文数字转换为一位数字;eg:一返回1;

     *

     *@paramonlyCNNumber

     *@return 

     */

    public static int numberCharCN2Arab(char onlyCNNumber) {


        if(numChars[0] == onlyCNNumber) {

            return 1;

        }else if(numChars[1] == onlyCNNumber || onlyCNNumber =='两') {//处理中文习惯用法(二,两)

            return 2;

        }else if(numChars[2] == onlyCNNumber) {

            return 3;

        }else if(numChars[3] == onlyCNNumber) {

            return 4;

        }else if(numChars[4] == onlyCNNumber) {

            return 5;

        }else if(numChars[5] == onlyCNNumber) {

            return 6;

        }else if(numChars[6] == onlyCNNumber) {

            return 7;

        }else if(numChars[7] == onlyCNNumber) {

            return 8;

        }else if(numChars[8] == onlyCNNumber) {

            return 9;

        }


        return 0;

    }


    /**

     *将一位数字转换为一位中文数字;eg:1返回一;

     *

     *@paramonlyArabNumber

     *@return 

     */

    public static char numberCharArab2CN(char onlyArabNumber) {


        if(onlyArabNumber =='0') {

            return numZero;

        }


        if(onlyArabNumber >'0'&& onlyArabNumber <='9') {

            return numChars[onlyArabNumber -'0'- 1];

        }


        return onlyArabNumber;

    }


    /**

     *

     *@paramnum

     *@return 

     */

    public static String numberArab2CN(Integer num) {


        String tempNum = num +"";


//传说中的分页算法;

        int numLen = tempNum.length();

        int start = 0;

        int end = 0;

        int per = 4;

        int total = (int) ((numLen + per - 1) / per);

        int inc = numLen % per;


        /*

         * 123,1234,1234四位一段,进行处理;

         */

        String[] numStrs =new String[total];


        for(int i = total - 1; i >= 0; i--) {

            start = (i - 1) * per + inc;


            if(start < 0) {

                start = 0;

            }


            end = i * per + inc;


            numStrs[i] = tempNum.substring(start, end);

        }


        String tempResultNum ="";


        int rempNumsLen = numStrs.length;

        for(int i = 0; i < rempNumsLen; i++) {


//小于1000补零处理;

            if(i > 0 && Integer.parseInt(numStrs[i]) < 1000) {

                tempResultNum +=numZero

                        +numberKArab2CN(Integer.parseInt(numStrs[i]));

            }else{

                tempResultNum +=numberKArab2CN(Integer.parseInt(numStrs[i]));

            }


//加上单位(万,亿....)

            if(i < rempNumsLen - 1) {

                tempResultNum +=bigUnits[rempNumsLen - i - 2];

            }


        }


//去掉未位的零

        tempResultNum = tempResultNum.replaceAll(numZero+"$","");


        return tempResultNum;

    }


    /**

     *将千以内的数字转换为中文数字;

     *

     *@paramnum

     *@return 

     */

    private static String numberKArab2CN(Integer num) {


        char[] numChars = (num +"").toCharArray();


        String tempStr ="";


        int inc =units.length- numChars.length;


        for(int i = 0; i < numChars.length; i++) {

            if(numChars[i] !='0') {

                tempStr +=numberCharArab2CN(numChars[i]) +units[i + inc];

            }else{

                tempStr +=numberCharArab2CN(numChars[i]);

            }

        }


//将连续的零保留一个

        tempStr = tempStr.replaceAll(numZero+"+",numZero+"");


//去掉未位的零

        tempStr = tempStr.replaceAll(numZero+"$","");


        return tempStr;


    }


    /**

     *处理千以内中文数字,返回4位数字字符串,位数不够以"0"补齐;

     *

     *@paramnumberCN

     *@return 

     */

    private static String numberKCN2Arab(String numberCN) {


        if("".equals(numberCN)) {

            return "";

        }


        int[] nums =new int[4];


        if(numberCN !=null) {


            for(int i = 0; i <units.length; i++) {

                int idx = numberCN.indexOf(units[i]);


                if(idx > 0) {

                    char tempNumChar = numberCN.charAt(idx - 1);


                    int tempNumInt =numberCharCN2Arab(tempNumChar);


                    nums[i] = tempNumInt;

                }

            }


//处理十位

            char ones = numberCN.charAt(numberCN.length() - 1);

            nums[nums.length- 1] =numberCharCN2Arab(ones);


//处理个位

            if((numberCN.length() == 2 || numberCN.length() == 1)

                    && numberCN.charAt(0) =='十') {

                nums[nums.length- 2] = 1;

            }

        }


//返回结果

        String tempNum ="";

        for(int i = 0; i < nums.length; i++) {

            tempNum += nums[i];

        }


        return (tempNum);

    }
}
