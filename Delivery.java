public class Delivery {
    private String packageId;
    private String sender;
    private String recipient;
    private String address;
    private boolean isFragile;

    private Delivery(Builder builder) {
        this.packageId = builder.packageId;
        this.sender = builder.sender;
        this.recipient = builder.recipient;
        this.address = builder.address;
        this.isFragile = builder.isFragile;
    }

    public String getPackageId() {
        return packageId;
    }

    public static class Builder {
        private String packageId;
        private String sender;
        private String recipient;
        private String address;
        private boolean isFragile;

        public Builder setPackageId(String packageId) {
            this.packageId = packageId;
            return this;
        }

        public Builder setSender(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder setRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setIsFragile(boolean isFragile) {
            this.isFragile = isFragile;
            return this;
        }

        public Delivery build() {
            return new Delivery(this);
        }
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "packageId='" + packageId + '\'' +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", address='" + address + '\'' +
                ", isFragile=" + isFragile +
                '}';
    }
}
