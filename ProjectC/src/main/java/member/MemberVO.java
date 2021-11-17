package member;


public class MemberVO {
    private String id, nickname, password, address, email, idnumber, filepath, filename, name, kind, joindate;

    
	public MemberVO(String id, String nickname, String password, String address, String email, String idnumber,
			String filepath, String filename, String name, String kind, String joindate) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.address = address;
		this.email = email;
		this.idnumber = idnumber;
		this.filepath = filepath;
		this.filename = filename;
		this.name = name;
		this.kind = kind;
		this.joindate = joindate;
	}



	public MemberVO(String id, String nickname, String password,
			String address, String email, String idnumber, String name, String filename) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.address = address;
		this.email = email;
		this.idnumber = idnumber;
		this.filename = filename;
		this.name = name;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
    
    
}