package es_board;

public class ES_BoardVO {
	private String eventnm, opar, eventco, eventstartdate, eventenddate, eventstarttime, eventendtime, chrgeinfo, mnnst, auspcinstt, phonenumber, suprtinstt,
				   seatnumber, admfee, entncage, dscntinfo, atpn, homepageurl, advantkinfo, prkplceyn, rdnmadr, lnmadr, atitude, longitude, referencedate, filename, filepath, writer;
	private int no, post_able, on_offline;
	
	
	
	public ES_BoardVO(String eventnm, String opar, String eventco, String eventstartdate, String eventenddate,
			String eventstarttime, String eventendtime, String chrgeinfo, String mnnst, String auspcinstt,
			String phonenumber, String suprtinstt, String seatnumber, String admfee, String entncage, String dscntinfo,
			String atpn, String homepageurl, String advantkinfo, String prkplceyn, String rdnmadr, String lnmadr,
			String atitude, String longitude, String referencedate, int no, String filename, String filepath, String wirter, int on_offline) {
		super();
		this.eventnm = eventnm;
		this.opar = opar;
		this.eventco = eventco;
		this.eventstartdate = eventstartdate;
		this.eventenddate = eventenddate;
		this.eventstarttime = eventstarttime;
		this.eventendtime = eventendtime;
		this.chrgeinfo = chrgeinfo;
		this.mnnst = mnnst;
		this.auspcinstt = auspcinstt;
		this.phonenumber = phonenumber;
		this.suprtinstt = suprtinstt;
		this.seatnumber = seatnumber;
		this.admfee = admfee;
		this.entncage = entncage;
		this.dscntinfo = dscntinfo;
		this.atpn = atpn;
		this.homepageurl = homepageurl;
		this.advantkinfo = advantkinfo;
		this.prkplceyn = prkplceyn;
		this.rdnmadr = rdnmadr;
		this.lnmadr = lnmadr;
		this.atitude = atitude;
		this.longitude = longitude;
		this.referencedate = referencedate;
		this.filename = filename;
		this.filepath = filepath;
		this.no = no;
		this.writer = wirter;
		this.on_offline = on_offline;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getOn_offline() {
		return on_offline;
	}
	public void setOn_offline(int on_offline) {
		this.on_offline = on_offline;
	}
	public String getEventnm() {
		return eventnm;
	}
	public void setEventnm(String eventnm) {
		this.eventnm = eventnm;
	}
	public String getOpar() {
		return opar;
	}
	public void setOpar(String opar) {
		this.opar = opar;
	}
	public String getEventco() {
		return eventco;
	}
	public void setEventco(String eventco) {
		this.eventco = eventco;
	}
	public String getEventstartdate() {
		return eventstartdate;
	}
	public void setEventstartdate(String eventstartdate) {
		this.eventstartdate = eventstartdate;
	}
	public String getEventenddate() {
		return eventenddate;
	}
	public void setEventenddate(String eventenddate) {
		this.eventenddate = eventenddate;
	}
	public String getEventstarttime() {
		return eventstarttime;
	}
	public void setEventstarttime(String eventstarttime) {
		this.eventstarttime = eventstarttime;
	}
	public String getEventendtime() {
		return eventendtime;
	}
	public void setEventendtime(String eventendtime) {
		this.eventendtime = eventendtime;
	}
	public String getChrgeinfo() {
		return chrgeinfo;
	}
	public void setChrgeinfo(String chrgeinfo) {
		this.chrgeinfo = chrgeinfo;
	}
	public String getMnnst() {
		return mnnst;
	}
	public void setMnnst(String mnnst) {
		this.mnnst = mnnst;
	}
	public String getAuspcinstt() {
		return auspcinstt;
	}
	public void setAuspcinstt(String auspcinstt) {
		this.auspcinstt = auspcinstt;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getSuprtinstt() {
		return suprtinstt;
	}
	public void setSuprtinstt(String suprtinstt) {
		this.suprtinstt = suprtinstt;
	}
	public String getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(String seatnumber) {
		this.seatnumber = seatnumber;
	}
	public String getAdmfee() {
		return admfee;
	}
	public void setAdmfee(String admfee) {
		this.admfee = admfee;
	}
	public String getEntncage() {
		return entncage;
	}
	public void setEntncage(String entncage) {
		this.entncage = entncage;
	}
	public String getDscntinfo() {
		return dscntinfo;
	}
	public void setDscntinfo(String dscntinfo) {
		this.dscntinfo = dscntinfo;
	}
	public String getAtpn() {
		return atpn;
	}
	public void setAtpn(String atpn) {
		this.atpn = atpn;
	}
	public String getHomepageurl() {
		return homepageurl;
	}
	public void setHomepageurl(String homepageurl) {
		this.homepageurl = homepageurl;
	}
	public String getAdvantkinfo() {
		return advantkinfo;
	}
	public void setAdvantkinfo(String advantkinfo) {
		this.advantkinfo = advantkinfo;
	}
	public String getPrkplceyn() {
		return prkplceyn;
	}
	public void setPrkplceyn(String prkplceyn) {
		this.prkplceyn = prkplceyn;
	}
	public String getRdnmadr() {
		return rdnmadr;
	}
	public void setRdnmadr(String rdnmadr) {
		this.rdnmadr = rdnmadr;
	}
	public String getLnmadr() {
		return lnmadr;
	}
	public void setLnmadr(String lnmadr) {
		this.lnmadr = lnmadr;
	}
	public String getAtitude() {
		return atitude;
	}
	public void setAtitude(String atitude) {
		this.atitude = atitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getReferencedate() {
		return referencedate;
	}
	public void setReferencedate(String referencedate) {
		this.referencedate = referencedate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPost_able() {
		return post_able;
	}
	public void setPost_able(int post_able) {
		this.post_able = post_able;
	}
	
}
