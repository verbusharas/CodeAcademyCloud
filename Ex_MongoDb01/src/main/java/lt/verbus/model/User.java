package lt.verbus.model;

public class User {
    private long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String address;
    private String password;

    private User(){
    }

    public static class Builder {
        private long id;
        private String name;
        private String surname;
        private int age;
        private String email;
        private String address;
        private String password;

        public Builder(long id) {
            this.id = id;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;  //By returning the builder each time, we can create a fluent interface.
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder atAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            User user = new User();
            user.id = this.id;
            user.name = this.name;
            user.surname = this.surname;
            user.email = this.email;
            user.address = this.address;
            user.password = this.password;
            return user;
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}
