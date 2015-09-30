package meiqin520;

import java.util.Set;

public class Stuenty {

	private String id;
	private String zhuangye;
	private  String renshu;
	private String kechengmingcheng;
	private String xuanxiuleixing;
	private String xuefen;
	private String xueshi;
	private String shangjixueshi;
	private String shiyanxueshi;
	private String qishizhouqi;
	private String renkejiaoshi;
	private String beizhu;
	public Stuenty(String id,String zhuangye,String renshu,String kechengmingcheng,String xuanxiuneixing,
			String xuefen,String xueshi,String shangjixueshi,String shiyanxueshi,String qishizhouqi,String renkejiaoshi,String beizhu) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.zhuangye=zhuangye;
		this.renshu=renshu;
		this.kechengmingcheng=kechengmingcheng;
		this.xuanxiunneixing=xuanxiuneixing;
		this.xuefen=xuefen;
		this.shangjixueshi=shangjixueshi;
		this.shiyanxueshi=shiyanxueshi;
		this.qishizhouqi=qishizhouqi;
		this.renkejiaoshi=renkejiaoshi;
		this.beizhu=beizhu;
		
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public void setKechenmingchen(String kechenmingchen) {
		this.kechenmingchen = kechenmingchen;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setQizhizhouqi(String qizhizhouqi) {
		this.qizhizhouqi = qishizhouqi;
	}
	public void setRenkejiaoshi(String renkejiaoshi) {
		this.renkejiaoshi = renkejiaoshi;
	}
	public void setShangjixueshi(String shangjixueshi) {
		this.shangjixueshi = shangjixueshi;
	}
	public void setShiyanxueshi(String shiyanxueshi) {
		this.shiyanxueshi = shiyanxueshi;
	}
	public void setXuanxiuleixing(String xuanxiuleixing) {
		this.xuanxiuleixing = xuanxiuleixing;
	}
	public void setXuefen(String xuefen) {
		this.xuefen = xuefen;
	}
	public void setXueshi(String xueshi) {
		this.xueshi = xueshi;
	}
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	public void setRenshu(String renshu) {
		this.renshu = renshu;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public String getKechenmingcheng() {
		return kechenmingcheng;
	}
	public String getId() {
		return id;
	}
	public String getQizhizhouqi() {
		return qizhizhouqi;
	}
	public String getRenkejiaoshi() {
		return renkejiaoshi;
	}
	public int getShangjixueshi() {
		return shangjixueshi;
	}
	public int getShiyanxueshi() {
		return shiyanxueshi;
	}
	public String getXuanxiuleixing() {
		return xuanxiuleixing;
	}
	public int getXuefen() {
		return xuefen;
	}
	public int getXueshi() {
		return xueshi;
	}
	public String getZhuanye() {
		return zhuanye;
	}
	public int getRenshu() {
		return renshu;
	}
	
	
}
