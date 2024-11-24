package Model;

public class Member {
    private int memberID;
    private String name;
    private String contactNo;
    private String address;
    private String password;
    private MembershipCard membershipCard;

    public Member(int memberID, String name, String contactNo, String address, String password, MembershipCard membershipCard) {
        this.memberID = memberID;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.password = password;
        this.membershipCard = membershipCard;
    }

    public Member() {}

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MembershipCard getMembershipCard() {
        return membershipCard;
    }

    public void setMembershipCard(MembershipCard membershipCard) {
        this.membershipCard = membershipCard;
    }
}
