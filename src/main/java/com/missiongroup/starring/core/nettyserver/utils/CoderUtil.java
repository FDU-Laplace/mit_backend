package com.missiongroup.starring.core.nettyserver.utils;

import com.missiongroup.starring.core.cache.ICache;
import com.missiongroup.starring.core.cache.service.PortModel;
import com.missiongroup.starring.core.util.SpringContextHolder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

public class CoderUtil {
    private static final Logger logger = Logger.getLogger(CoderUtil.class);

    public static byte[] readBuffer(ByteBuf buffer) {
        byte[] bs = new byte[buffer.readableBytes()];
        buffer.readBytes(bs);
        return bs;
    }

    public static byte[] object2Bytes(Object obj) {
        byte[] bs = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            bs = bos.toByteArray();
        } catch (IOException e) {
            logger.error(e);
        } finally {
            try {
                oos.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bs;
    }

    public static Object bytes2Object(byte[] bs) {
        Object obj = null;
        ObjectInputStream ois = null;
        ByteArrayInputStream bis = new ByteArrayInputStream(bs);
        try {
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                bis.close();
            } catch (IOException e) {
                logger.error(e);
            }
        }
        return obj;
    }

    public final static String md5Encoder(byte[] buffer) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] intToByteArray(int value) {
        byte[] byte_src = new byte[4];
        byte_src[3] = (byte) ((value & 0xFF000000) >> 24);
        byte_src[2] = (byte) ((value & 0x00FF0000) >> 16);
        byte_src[1] = (byte) ((value & 0x0000FF00) >> 8);
        byte_src[0] = (byte) ((value & 0x000000FF));
        return byte_src;
    }

    public static int ByteArrayToInt(byte[] bArr) {
        if (bArr.length != 4) {
            return -1;
        }
        return (int) ((((bArr[3] & 0xff) << 24) | ((bArr[2] & 0xff) << 16) | ((bArr[1] & 0xff) << 8) | ((bArr[0] & 0xff) << 0)));
    }

    @SuppressWarnings("unchecked")
    public static Map<Object, Object> readStringXmlOut(String xml) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            Iterator<Object> iter = rootElt.elementIterator("data");
            while (iter.hasNext()) {
                Element recordEle = (Element) iter.next();
                String result = recordEle.elementTextTrim("result");
                map.put("result", result);
            }
        } catch (DocumentException e) {
            logger.error(e);
        }
        return map;
    }


    public static JSONObject assembleGlobal() {
        JSONObject item = new JSONObject();
        JSONObject msg = new JSONObject();
        item.put("key", 0);
        msg.accumulate("global", item);
        return msg;
    }

    /**
     * 字符串使用utf-8编码
     *
     * @param code
     * @return
     */
    public static String UTF8Encode(String code) {
        String result = StringUtils.EMPTY;
        try {
            result = URLEncoder.encode(URLEncoder.encode(code != null ? code : "", "UTF-8"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return result;
    }

    /**
     * 字符串使用utf-8解码
     *
     * @param code
     * @return
     */
    public static String UTF8Decode(String code) {
        String result = StringUtils.EMPTY;
        try {
            result = URLDecoder.decode(URLDecoder.decode(code != null ? code : "", "UTF-8"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return result;
    }

    /**
     * Description: 消息ID生成器
     */
    public static String GeneralMessageID() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String tag = String.format("%03d", (int) (Math.random() * 1000));
        return sdf.format(new Date()) + tag;
    }

    /**
     * @return DO: 获取IP地址
     */
    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = (InetAddress) addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address && ip.getHostAddress().indexOf(".") > -1 && !ip.getHostAddress().startsWith("127.0.0.")) {
                        return ip.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, PortModel> transform(ByteBuf byteBuf, List o) {
        Map<String, PortModel> data = new LinkedHashMap<>();
        for (int i = 0; i < o.size(); i++) {
            PortModel portModel = (PortModel) o.get(i);
            String signalName = portModel.getSignalName();
            String complexNetworkType = portModel.getComplexNetworkType().trim();
            if (complexNetworkType.equals("BOOL") || complexNetworkType.equals("BOOLEAN1")) {
                byte readByte = byteBuf.readByte();
                int[] booleanArray = getBooleanArray(readByte);
                int i2 = booleanArray[0];
                portModel.setValue(Long.valueOf(i2));
                data.put(signalName, portModel);
                for (int i1 = 1; i1 <= 7; i1++) {
                    int d = booleanArray[i1];
                    if ((i + i1) >= o.size()) {
                        break;
                    }
                    PortModel portModel2 = (PortModel) o.get(i + i1);
                    String signalName2 = portModel2.getSignalName();
                    portModel2.setValue(Long.valueOf(d));
                    data.put(signalName2, portModel2);
                }
                i = i + 7;
            } else {
                Object v = null;


                switch (complexNetworkType) {
                    case "UNSIGNED8":
                    case "BYTE":
                        v = byteBuf.readUnsignedByte();
                        break;
                    case "INTEGER8":
                    case "SINT":
                    case "CHAR":
                        v = byteBuf.readByte();
                        break;
                    case "UNSIGNED16":
                    case "WORD":
                        v = byteBuf.readUnsignedShort();
                        break;
                    case "INTEGER16":
                    case "INT":
                        v = byteBuf.readShort();
                        break;
                    case "UNSIGNED32":
                    case "DWORD":
                    case "REAL32":
                        v = byteBuf.readUnsignedInt();
                        break;
                    case "INTEGER32":
                        v = byteBuf.readInt();
                        break;
                    default:
                        break;
                }
                Long i1 = Long.valueOf(String.valueOf(v));
                portModel.setValue(i1);
                data.put(signalName, portModel);
            }
        }
        byteBuf.resetReaderIndex();
        byteBuf.readBytes(36-34);
        Object portStatus = byteBuf.readUnsignedShort();
        Long i1 = Long.valueOf(String.valueOf(portStatus));
        PortModel portModel=new PortModel();
        portModel.setValue(i1);
        portModel.setSignalName("portStatus");
        data.put("portStatus",portModel);
        return data;
    }

    public static int[] getBooleanArray(byte b) {
        int[] array = new int[8];
        for (int i = 7; i >= 0; i--) {
            array[i] = (byte) (b & 1);
            b = (byte) (b >> 1);
        }
        return array;
    }
}