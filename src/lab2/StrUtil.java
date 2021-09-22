package lab2;//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.text.StrBuilder;
//
//import javax.servlet.http.HttpServletRequest;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://blog.csdn.net/echizao1839/article/details/80890490
public class StrUtil {

//    好像没用啊
//    public static String urlEncode(String url) throws UnsupportedEncodingException {
//        if (url == null) {
//            return null;
//        }
//
//        final String reserved_char = ";/?:@=&";
//        StringBuilder ret = new StringBuilder();
//        for (int i = 0; i < url.length(); i++) {
//            String cs = String.valueOf(url.charAt(i));
//            if (reserved_char.contains(cs)) {
//                ret.append(cs);
//            } else {
//                ret.append(URLEncoder.encode(cs, "utf-8"));
//            }
//        }
//        return ret.toString().replace("+", "%20");
//    }

    public static String quotation(Object object) {
        return " '" + object + "' ";
    }

    public static String like(Object object) {
        return " '%" + object + "%' ";
    }


    /**
     * StrUtil 类，声明省略
     */
    enum Place {
        BELOW, UP
    }


    /**
     * byte	Byte
     * short	Short
     * int	Integer
     * long	Long
     * float	Float
     * double	Double
     * boolean	Boolean
     * char	Character
     *
     * @param canonicalName
     * @return
     */
    public static String primaryToPackaging(String canonicalName) {
        switch (canonicalName) {
            case "byte":
                return "java.lang.Byte";
            case "short":
                return "java.lang.Short";
            case "int":
                return "java.lang.Integer";
            case "long":
                return "java.lang.Long";
            case "float":
                return "java.lang.Float";
            case "double":
                return "java.lang.Double";
            case "boolean":
                return "java.lang.Boolean";
            case "char":
                return "java.lang.Character";
            default:
                return canonicalName;
        }
    }

    //
//    public static String getRequestContain(HttpServletRequest request) {
//
//        Enumeration enu = request.getParameterNames();
//        StringBuilder stringBuilder = new StringBuilder();
//        while (enu.hasMoreElements()) {
//            String paraName = (String) enu.nextElement();
//            stringBuilder.append(paraName).append(": ").
//                    append(request.getParameter(paraName)).append(", ");
////        System.out.println(paraName+": "+request.getParameter(paraName));
//        }
//        return stringBuilder.toString();
//    }
    public static String addBackslash(String origin) {
//        return origin.replaceAll("[\"']", "\\\\$0");
        return origin.replace("'", "\\\"");
    }

    /**
     * '  -> "
     *
     * @param origin
     * @return
     */
    public static String singleQuotationMarkToDouble(String origin) {
//        return origin.replaceAll("[\"']", "\\\\$0");
        return origin.replace("'", "\"");
    }

    //format方法
    public static String formatToFour0(String s) {

//写上你要怎么处理字符串
//这里假定是一个1到4位的整数，不足四位时前面补0
        int len = s.length();
//不足四位
//        https://zhidao.baidu.com/question/175025220.html
        if (len < 4) {
            int prefixNum = 4 - len;//计算要补几个0
//前面补0
            StringBuilder sBuilder = new StringBuilder(s);
            for (int i = 0; i < prefixNum; i++) {
                sBuilder.insert(0, "0");
            }
            s = sBuilder.toString();
        }
        return s;
    }

    //正则表达式   :   完美
    public static boolean isNumber(String str) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }

    //    void leftSlashToRightSlash(String string){
//
//    }

    /**
     * 去掉前面的0的parseInt
     *
     * @param str
     * @return
     */
    public static int parseInt(String str) {

        int start = 0;

        while (str.charAt(start) == '0') start++;
        str = str.substring(start);
        return Integer.parseInt(str);
    }

//    public final static String[] encodeTable = new String[2^9];
//    static{
//        for(int i=0;i<256;i++)
//        {
//            if(i>='0' && i<='9' || i>='a'&&i<='z' || i>='A' && i<='Z' || i=='-' || i=='_' || i=='.')
//            {
//                encodeTable[i] = (char)i + "";
//            }else
//            {
//                encodeTable[i] = "%" + String.format("%02x",i).toUpperCase();
//            }
//        }
//    }

    //    可以用
    public static String urlEncode(final String sourceStr) {

        String[] encodeTable = new String[277];
        for (int i = 0; i < 256; i++) {
            if (i >= '0' && i <= '9' || i >= 'a' && i <= 'z' || i >= 'A'
                    && i <= 'Z' || i == '-' || i == '_' || i == '.') {
                encodeTable[i] = (char) i + "";
            } else {
                encodeTable[i] = "%" + String.format("%02x", i).toUpperCase();
            }
        }


        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sourceStr.length(); i++) {
            sb.append(encodeTable[sourceStr.charAt(i) & 0xFF]);
        }
        return sb.toString();
    }
//
//   static void put(JSONObject jsonObject){
//        jsonObject.put("1","1");
//
//    }
//
//  static   void  test4(){
////      {"1":"1"}
////      传递 引用 可以的
//      JSONObject jsonObject = new JSONObject();
//      put(jsonObject);
//      System.out.println(jsonObject);
//
//    }
//
//    static  void test2(){
//        JSONObject jsonObject=new JSONObject();
////        jsonObject.put("1",null);
//        jsonObject.put("2","2");
//        Object o = jsonObject.get("1");
//        if(o==null){
//            System.out.println("null it is");
//        }
//        System.out.println("o");
//        System.out.println(o);
//    }

    void test3() {

        String s = "sendid=5b29bc46633f0a01c32c85338f4179384d0654c86e02006e6520782660228afb&ver=8&sign" +
                "=797499f8f88b31bb48c65b899d333106d8e125629208d571c75900dac20da9a57362f4e26457f33cb4f43bc81f0098165c84b7917aa9d84274700e054c813b65&mchid=131127135&spid=1610488738";
        String s1 = urlEncode(s);
//        URLEncoder.encode(s, "UTF-8");
//        private static final String DEFAULT_CHARSET = "UTF-8";
        System.out.println("s1");
        System.out.println(s1);

//        true
//        一样的
        System.out.println(("sendid%3D5b29bc46633f0a01c32c85338f4179384d0654c86e02006e6520782660228afb%26ver%3D8" +
                "%26sign" +
                "%3D797499f8f88b31bb48c65b899d333106d8e125629208d571c75900dac20da9a57362f4e26457f33cb4f43bc81f0098165c84b7917aa9d84274700e054c813b65%26mchid%3D131127135%26spid%3D1610488738").equals(s1));

    }

    public static void main(String[] args) throws UnsupportedEncodingException {

//        test2();
//        test4();
    }

    //    https://www.php.cn/java/base/435948.html
    public static boolean isNumeric(String str) {

        for (int i = str.length(); --i >= 0; ) {

            if (!Character.isDigit(str.charAt(i))) {

                return false;

            }

        }

        return true;

    }

    /*

     * 判断是否为整数

     * @param str 传入的字符串

     * @return 是整数返回true,否则返回false

     */

    public static boolean isInteger(String str) {

        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");

        return pattern.matcher(str).matches();

    }

//    public static boolean isNumeric(String str){
//
//        Pattern pattern = Pattern.compile("[0-9]*");
//
//        return pattern.matcher(str).matches();
//
//    }

    void test1() {
        //        oneLineJapaneseOneLineChineseShow();
//        and();
//        getLines();
//        getBelowLinesInPara();
//        String str = "1234";
//        String stripChars = "124";
//        3
//        也就是说 stripchars 里面带有的东西 都会被消掉
//        System.out.println(StringUtils.strip(str, stripChars));
//        System.out.println(StringUtils.trim(str));  //消除空格
//        System.out.println(StringStartTrim(str, stripChars));
//        System.out.println(rDelStr(str, stripChars));
//        String string = "1：1";
//        System.out.println(Arrays.toString(string.split("[:：]")));

//        String res = addBackslash("{'id':'1','name':'jojo','gender':'男'}");
//        java 有没有类似 r"" python

//        System.out.println(res);

//       String jsonStr=  StrUtil.addBackslash("'{'data':'java send'}'");
    }

//    void jsonTest() {
////        ok
//        String jsonStr = StrUtil.singleQuotationMarkToDouble("{'data':'java send'}");
//        System.out.println("jsonStr");
//        System.out.println(jsonStr);
//
//        String result = "\n" +
//                "{\n" +
//                " \n" +
//                "    \"success\":\"true\",\n" +
//                " \n" +
//                "    \"returnAddress\":\"123\"\n" +
//                " \n" +
//                "}";
//        System.out.println("result right");
//        System.out.println(result);
//
//
//        JSONObject jsonObject = JSON.parseObject(jsonStr);
////        JSONObject jsonObject= JSON.parseObject(StrUtil.addBackslash("{data:java send}"));
//        System.out.println(jsonObject);
////        JSON.toJSONString({"1":"2"})
//
//        JSONObject jsonObject2 = JSON.parseObject(result);
//        System.out.println(jsonObject2);
//    }

    /**
     * 去掉指定字符串的开头的指定字符
     *
     * @param stream 原始字符串
     * @param trim   要删除的字符串
     * @return 这个是trim的前面部分，如果stream里面有的话，会被删掉，比如说
     * trim是124，stream是1234，那么前面一样的12 会被删掉，变成34
     */
    public static String StringStartTrim(String stream, String trim) {
        // null或者空字符串的时候不处理
        if (stream == null || stream.length() == 0 || trim == null || trim.length() == 0) {
            return stream;
        }
        // 要删除的字符串结束位置
        int end;
        // 正规表达式
        String regPattern = "[" + trim + "]*+";
        Pattern pattern = Pattern.compile(regPattern, Pattern.CASE_INSENSITIVE);
        // 去掉原始字符串开头位置的指定字符
        Matcher matcher = pattern.matcher(stream);
        if (matcher.lookingAt()) {
            end = matcher.end();
            stream = stream.substring(end);
        }
        // 返回处理后的字符串
        return stream;
    }

    public static String frontDelStr(String oldStr, String dontWant) {

        if (dontWant.equals("")) {
            return oldStr;
        }
        int oldStrLen = (oldStr).length();
        int dontWantLen = (dontWant).length();
        int minLen = Math.min(oldStrLen, dontWantLen);

        int iOld = 0;
        int iDont = 0;

        int iRes = 0;
        int iNow = 0;
        while (true) {


            if (!(oldStr.charAt(iOld) == dontWant.charAt(iDont))) {
                return oldStr.substring(iRes, oldStrLen - iRes);
            }

            iNow++;
            if (iNow - iRes == dontWantLen) {
                iRes += dontWantLen;

            }
            if (iDont == minLen - 1 || iOld == minLen - 1)
                return oldStr.substring(iRes, oldStrLen - iRes);

            iOld++;
            iDont++;

        }
    }


//  public static String getBasePath(HttpServletRequest request){
//        String path = request.getContextPath();
//      return request.getScheme()+"://"+request.getServerName()
//              +":"+request.getServerPort()+path+"/";
//    }

    /**
     * 从背后删除字符串，比如1234，我不要34，就会得到12.比如1234，我不要2，如果是
     * strip的话，就会把那个2也删掉的，但是我这个是直接忽略，因为最后没有2，返回的
     * 还是1234
     *
     * @param oldStr   原来的字符串
     * @param dontWant 不想要的字符串
     * @return
     */
    public static String rDelStr(String oldStr, String dontWant) {
        //todo ,completed
        if (dontWant.equals("")) {
            return oldStr;
        }
        int oldStrLen = (oldStr).length();
        int dontWantLen = (dontWant).length();
        int iOld = oldStrLen - 1;
        int iDont = dontWantLen - 1;

        int iRes = oldStrLen;
        int iNow = oldStrLen;
        while (true) {


            if (!(oldStr.charAt(iOld) == dontWant.charAt(iDont))) {
                return oldStr.substring(0, iRes);
            }

            iNow -= 1;
            if (iRes - iNow == dontWantLen) {
                iRes -= dontWantLen;

            }
            if (iDont == 0 || iOld == 0)
                return oldStr.substring(0, iRes);

            iOld--;
            iDont--;

        }

    }

    static void getLinesInPara(Place place) {

        System.out.println("get " + (place.equals(Place.BELOW) ? "below" : "up")
                + " lines ,input eof to stop input");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        List<String> strings = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("eof")) {
                break;
            }
            if ((i & 1) == (place.equals(Place.BELOW) ? 1 : 0)) {
                strings.add(s);
            }
            i++;
        }
        for (String s : strings) {
            System.out.println(s);
        }
    }

    static void getBelowLinesInPara() {
        getLinesInPara(Place.BELOW);

    }

    //    https://blog.csdn.net/sinaihalo/article/details/80908399
//    @WriteDataSource
    public static void updateEquipmentAssets(String tableName, List<String> keyList, List<String> valueList) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(tableName).append(" SET ");//equipmentassetstable
        for (int i = 0; i < keyList.size(); i++) {
            if (!"ID".equals(keyList.get(i))) {
                sb.append(keyList.get(i));
                sb.append("=");
                sb.append("'").append(valueList.get(i)).append("'");
                if (i != keyList.size() - 1) {
                    sb.append(",");
                }
            }

        }
        for (int i = 0; i < keyList.size(); i++) {
            if ("ID".equals(keyList.get(i))) {
                sb.append(" WHERE ID = '").append(valueList.get(i)).append("'");
            }
        }
        //jt.execute(sb.toString());
        System.out.println(sb);
    }

    public static void splitJointUpdateSql(String tableName, Map<String, String> setMap,
                                           Map<String, String> conditionMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(tableName).append(" SET ");//equipmentassetstable

//        https://www.cnblogs.com/damoblog/p/9124937.html
        int size = setMap.size();
        int i = 0;
        for (Map.Entry<String, String> entry : setMap.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            sb.append(mapKey).append("='").append(mapValue).append("'");
//            System.out.println(mapKey+":"+mapValue);
            if (i != size - 1) {
                sb.append(",");
            }
            i++;
        }
        i = 0;
        size = conditionMap.size();
        sb.append(" where ");
        for (Map.Entry<String, String> entry : conditionMap.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            sb.append(mapKey).append("=").append(mapValue);
            if (i != size - 1) {
                sb.append(" and ");
            }
            i++;
        }
//
//        for(int i=0;i<keyList.size();i++){
//            if(!"ID".equals(keyList.get(i))){
//                sb.append(keyList.get(i));
//                sb.append("=");
//                sb.append("'").append(valueList.get(i)).append("'");
//                if(i!=keyList.size()-1){
//                    sb.append(",");
//                }
//            }
//
//        }
//        for(int i=0;i<keyList.size();i++){
//            if("ID".equals(keyList.get(i))){
//                sb.append(" WHERE ID = '").append(valueList.get(i)).append("'");
//            }
//        }
        //jt.execute(sb.toString());
        System.out.println(sb);
    }


    public static StringBuilder listToStringBuilder(List<String> list, String suffix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            stringBuilder.append(string).append(suffix);
        }
        return stringBuilder;
    }

    public static StringBuilder listToStringBuilder(List<String> list, String suffix, Boolean endNo) {
        StringBuilder stringBuilder = new StringBuilder();
        if (endNo) {
            int size = list.size();
            int i = 0;

            for (String string : list) {
                stringBuilder.append(string);
                if (i != size - 1) stringBuilder.append(suffix);
                i++;
            }

        } else {

            for (String string : list) {
                stringBuilder.append(string).append(suffix);

            }
        }
        return stringBuilder;

    }

    public static StringBuilder oneLineJapaneseOneLineChinese(String japanese, String chinese) {
        String[] splitJapanese = japanese.split("\n");
        String[] splitChinese = chinese.split("\n");
        StringBuilder sb = new StringBuilder();
        int len = splitJapanese.length;
        for (int i = 0; i < len; i++) {
            sb.append(splitJapanese[i]).append("\n").append(splitChinese[i]);
        }
        return sb;
    }

    public static StringBuilder oneLineJapaneseOneLineChinese(List<String> japaneseList,
                                                              List<String> chineseList) {
//        String[] splitJapanese = japanese.split("\n");
//        String[] splitChinese = chinese.split("\n");
        StringBuilder sb = new StringBuilder();
        int len = japaneseList.size();
        for (int i = 0; i < len; i++) {
            sb.append(japaneseList.get(i)).append("\n").append(chineseList.get(i)).append("\n");
        }
        return sb;
    }

    //    https://www.runoob.com/java/java-scanner-class.html
    public static void oneLineJapaneseOneLineChineseShow() {
        Scanner scanner = new Scanner(System.in);
        List<String> japaneseList = new ArrayList<>();
        List<String> chineseList = new ArrayList<>();
        // 判断是否还有输入
        System.out.println("把一串日语和一串中文交错放置");
        System.out.println("输入一串日语，以eof结尾，并且回车");
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine();
            if (str1.equals("eof")) break;
//            System.out.println("输入的数据为：" + str1);
            japaneseList.add(str1);
        }
        System.out.println("输入一串中文，以eof结尾，并且回车");
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine();
            if (str1.equals("eof")) break;
//            System.out.println("输入的数据为：" + str1);
            chineseList.add(str1);
        }
        scanner.close();

        System.out.println(oneLineJapaneseOneLineChinese(japaneseList, chineseList));

    }

    static List<String> getBelowLines(String lines) {

        return getLines(lines, "below");
    }

    static List<String> getLines(String lines, String where) {
        String[] strings = lines.split("\n");
        List<String> belowLines = new ArrayList<>();

        int len = strings.length;
        for (int i = 0; i < len; i++) {
            if ((i & 1) == (where.equals("below") ? 1 : 0)) {
                belowLines.add(strings[i]);
            }
        }
        return belowLines;
    }

    static void and() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i & 1);
        }
    }

//    public static void main(String[] args) {
////        StrUtil.addBackslash();
//
//        test2();
//    }
}

