package QA.Enums;

public enum TRELLO {
    ;


    TRELLO() {
    }

    public enum USER{
        OMER("55e16ad2c31b938ce3fb6a0f30ec23456f499c660fad636ef9fffe62e961b69d", "a0d5260b986923aae1ba3b5e429be98e"),
        SELMAN("24860d90a9d5d2b65f3af1f5c4b71a4364216f9ef77d48a41c7dc484bc737ad6","850e65ed7ceafb7c99999afa1ca28a90"),
        YUSUF("118ebfe3d42cc3dce1a6bf3215b4b684e03406ed062c8e4312125261f4486382", "677bc9c8fa56c7f63325f9f40207227f")
        ;
        private String token,key;

        USER(String token, String key) {
            this.token = token;
            this.key = key;
        }

        public String getToken() {
            return token;
        }

        public String getKey() {
            return key;
        }
    }

    public enum CARTS{
        LISTE1KART1("a0d5260b986923aae1ba3b5e429be98e","63093a7966409f009c7bbaba","63093a72ab1ebe0200f2d270"),
        YUSUFlISTCARD("630feea638f391018724e8b2", "6309394e058aea01446bde63","63093a72ab1ebe0200f2d270"),
        ;
        private String id,idBoard,idList;

        CARTS(String id, String idBoard, String idList) {
            this.id = id;
            this.idBoard = idBoard;
            this.idList = idList;
        }

        public String getId() {
            return id;
        }

        public String getIdBoard() {
            return idBoard;
        }

        public String getIdList() {
            return idList;
        }
    }

}
