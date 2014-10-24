package compass;

public class QQIpConverter { 
	public static long ipToLong(String strIP) 
	//将127.0.0.1 形式的IP地址转换成10进制整数，这里没有进行任何错误处理 
	{ 
		//System.out.println("执行了QQIPConverter");
	int j=0; 
	int i=0; 
	long [] ip=new long[4]; 
	int position1=strIP.indexOf("."); 
	int position2=strIP.indexOf(".",position1+1); 
	int position3=strIP.indexOf(".",position2+1); 
	ip[0]=Long.parseLong(strIP.substring(0,position1)); 
	ip[1]=Long.parseLong(strIP.substring(position1+1,position2)); 
	ip[2]=Long.parseLong(strIP.substring(position2+1,position3)); 
	ip[3]=Long.parseLong(strIP.substring(position3+1)); 
	return (ip[0]<<24)+(ip[1]<<16)+(ip[2]<<8)+ip[3]; //ip1*256*256*256+ip2*256*256+ip3*256+ip4 
	} 
	public static String longToIP(long longIP) 
	//将10进制整数形式转换成127.0.0.1形式的IP地址，在命令提示符下输入ping 3396362403L 
	{ 
	StringBuffer sb=new StringBuffer(""); 
	sb.append(String.valueOf(longIP>>>24));//直接右移24位 
	sb.append("."); 
	sb.append(String.valueOf((longIP&0x00FFFFFF)>>>16)); //将高8位置0，然后右移16位 
	sb.append("."); 
	sb.append(String.valueOf((longIP&0x0000FFFF)>>>8)); 
	sb.append("."); 
	sb.append(String.valueOf(longIP&0x000000FF)); 
	sb.append("."); 
	return sb.toString(); 
	} 
	public static void main(String[] args) 
	{ 
	System.out.println("IP地址的各种表现形式：\r\n"); 
	System.out.print("32位二进制形式："); 
	System.out.println(Long.toBinaryString(3396362403L)); 
	System.out.print("十进制形式："); 
	System.out.println(ipToLong("202.112.96.163")); 
	System.out.println((long)ipToLong("202.112.96.163"));
	System.out.print("普通形式："); 
	System.out.println(longToIP(3396362403L)); 
	} 
	} 
