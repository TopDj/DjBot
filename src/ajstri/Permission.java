package ajstri;

public enum Permission {
	Everyone(new String[]{"e"}),
	AJ(new String[]{""}),
	Admins(new String[]{"", "", "", ""}),
	;
	
	private String[] p;
	
	private Permission(String[] p) {
		this.p = p;
	}
	
	public String[] getUsers() {
		return p;
	}
}