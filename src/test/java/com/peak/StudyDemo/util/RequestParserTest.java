package com.peak.StudyDemo.util;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class RequestParserTest {

	@Test
	public void fun1(){
		String queryString = "aaa/query?type=1,2,3&adtime=75&trule=38109&du=2438&al=9272379&out=0&au=1&vid=3513549&tvid=86890431&qd=&rt=1f3961c662eb8258&uv=14817138614388935655&uuid=47dcd879-88a8-9564-9b53-000000000159af57d2993c6d&vt=vrs&rd=tv.sohu.com&fee=0&isIf=0&suv=1612141910440961&uid=14847054856715291834&sz=800_583&md=yFkGlymdBFjrcjQ2HFplM7iW%20mJoUfz0156&crid=0&ar=6&sign=EV6IerpKuG1To57pLQRYvfFjeMvGBBzIJiRygkZ1AecJtMmxsMn3BGJ74lJtAKnoe1mB5izg7-7Pcgrq&rip=218.22.172.254&sip=&url=http%3A//tv.sohu.com/20170117/n478985911.shtml%3Flcode%3DAAAASQU8kURkaDGqi190Q98l4wrq6Blr_F09YAo5ruhGkY1tFD5vfosghb2Edszzh3BJDQ2hAtbQ4d5oZ1W2arK0XD7_r6oLKk35Qvon024w_tiExdl%26lqd%3D17939&pagerefer=http%3A//www.wabi360.com/Html/v/133.html&ti=0KGy3cfgx+C12jM4vK8=&lrd=&vp=s&at=15&c=1&s1=&v1=1048&v2=1125&p=oad4&loc=CN3405&mx=5&rlv=&ac=20031&ad=374887&pt=24677&b=447962&bk=104785419&pagetype=1&err=0&encrysig=wXR5I9PWx-qthbjNGadKrGyJojqzUqpZ2qugjdbTfUrJjAGY&encrypt=iAzFfnotqSYURIDsTHZMXNqJ6gxKwGUyE_FCRCu-icqbcE23";
		//queryString = "type=1&xxxxxx=&adtime=75&trule=38109&du=2673&al=9198543&out=0&au=1&vid=3422465&tvid=86067747&qd=&rt=61bd6be56529ca30&uv=14846215466616968092&uuid=97616a2e-db5a-7bea-a29f-000000000159af627a60d2ca&vt=vrs&rd=tv.sohu.com&fee=0&isIf=0&suv=6840BA5356034EC56041C13549DC4C7C&yyid=6840BA5356034EC56041C13549DC4C7C&uid=14846215466616968092&sz=991_468&md=yvL5Y9bBZuizQ85J2jTtiuBPlIjJGiu3211&crid=0&ar=6&sign=CEC9T0tx1pUV1nVop808jhFiTAVN2Qcf6aZHpO3NKoeMx0lj59VQusGw8KwkATrF-FWP4TTNzHk.&rip=113.70.157.63&sip=&url=http%3A//tv.sohu.com/20161122/n473874786.shtml%3Ftxid%3D351f624a85d86201915c41c0e4d05d20&pagerefer=http%3A//tv.2345.com/detail/49575.html%3Fjs001114&ti=xvfB6bXaN7yv&lrd=&vp=s&at=30&c=1&s1=&v1=1048&v2=1128&p=oad1,oad2&loc=CN4406&mx=5&rlv=&ac=19972&ad=377814&pt=24619&b=446031&bk=104522882&pagetype=1&err=0&encrysig=8L0og244so_3aiQp7-5XqEisZVmyD6-lbC6Fgy-r2WwDX-h8&encrypt=5iMUSLWcojiKI-BwqWbmkI3PKSUfBLhxeBT-T2YOh77whlsI";
		//queryString = "v2	[18/Jan/2017:15:25:30 +0800]	222.243.207.51	1701181520098076	type=1&du=1237&al=9133619&out=0&au=1&vid=3527813&tvid=87007530&qd=&rt=746fb36a45d44d9a&uv=14847240095497579445&uuid=b3a1976f-0abf-9c5d-45de-000000000159b07279352329&vt=vrs&rd=tv.sohu.com &fee=0&isIf=0&suv=1701181520098076&uid=14847240095497579445&oth=17938&cd=AAAAS1vHxPNhxhHAafgv56LtCzojYTWkAvGrIUMqI5yfdNQatQEqES8XbCI3FipqhxjdoNP78h7peAFjSa0Ml_pgKTmQtGg96RhexNZuPT7Uw7Zlnea&sz=745_545&md=X1yi8c9gSb5UT4S7vyXD8WU5FZoYpCli106&crid=0&ar=30&sign=jmnLc85c3v9RSH6xHzHIL9wHhz_59CDYzKc6g7ZMCdrlXhRtHgLTC4YpVbz76ycQus7Y52CVggrb4bef&rip=222.243.207.51&sip=10.10.93.205&url=http%3A//tv.sohu.com/20170112/n478507866.shtml%3Flcode%3DAAAAS1vHxPNhxhHAafgv56LtCzojYTWkAvGrIUMqI5yfdNQatQEqES8XbCI3FipqhxjdoNP78h7peAFjSa0Ml_pgKTmQtGg96RhexNZuPT7Uw7Zlnea%26lqd%3D17938&pagerefer=http%3A//www.044045.com/Html/i/7040988.html&ti=u629rbr+1q6yu8G8yMu12jK8vrXaMja8rw==&lrd=http%3A%2F%2Fwww.044045.com%2FHtml%2Fi%2F3245.html&vp=s&at=0&c=1&s1=&v1=1062&v2=18827&p=flogo&loc=CN4311&ac=19980&ad=373774&pt=24651&b=448556&bk=104784078&pagetype=1&encrysig=LphxkdQpK4Y9Q_6cBKszjrFr3rgkjNLAqeKaHWJmW9ebWp9O&encrypt=zHKAT6fVFH5MOV8cQIZCojzYNJH2FC_RZqLoZCLnu_ruQZp -	-	Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 UBrowser/5.6.14087.9 Safari/537.36	10.10.79.152	-	200";
		String enc = "utf-8";
		Map<Object,Object> map = RequestParser.getParamsMap(queryString, enc);
		
		for (Entry<Object, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() +"----------------------------------");
			String[] values = (String[]) entry.getValue();
			System.out.println("values长度："+values.length);
			for (String s : values) {
				System.out.println(s);
			}
		}
		
		
	}
	
	@Test
	public void fun2(){
		String queryString = "aaa/query?type=1";
		
		
		System.out.println(queryString.substring(1)+"----"+queryString);
//		System.out.println(queryString.indexOf("?"));
//		
//		queryString = queryString.substring(queryString.indexOf("?")+1);
//		System.out.println(queryString);
	}
	
	
	
}
