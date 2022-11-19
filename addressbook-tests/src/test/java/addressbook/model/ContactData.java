package addressbook.model;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String home;
    private final String mobile;
    private final String work;
    private final String fax;
    private final String bday;
    private final String bmonth;
    private final String year;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company,
                       String address, String home, String mobile, String work, String fax, String bday, String bmonth,
                       String year)
    {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.bday = bday;
        this.bmonth = bmonth;
        this.fax = fax;
        this.year = year;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getMiddlename() {
        return this.middlename;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCompany() {
        return this.company;
    }

    public String getAddress() {
        return this.address;
    }

    public String getHome() {
        return this.home;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getWork() {
        return this.work;
    }

    public String getBday() {
        return this.bday;
    }

    public String getBmonth() {
        return this.bmonth;
    }

    public String getFax() {
        return this.fax;
    }

    public String getYear() {
        return this.year;
    }
}