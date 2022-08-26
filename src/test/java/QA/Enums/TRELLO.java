package QA.Enums;

public enum TRELLO {
    OMER("55e16ad2c31b938ce3fb6a0f30ec23456f499c660fad636ef9fffe62e961b69d", "a0d5260b986923aae1ba3b5e429be98e", "a0d5260b986923aae1ba3b5e429be98e","63093a7966409f009c7bbaba","63093a72ab1ebe0200f2d270"),
    Selman("24860d90a9d5d2b65f3af1f5c4b71a4364216f9ef77d48a41c7dc484bc737ad6","850e65ed7ceafb7c99999afa1ca28a90","a0d5260b986923aae1ba3b5e429be98e","63093a7966409f009c7bbaba","63093a72ab1ebe0200f2d270")

    ;
    private String token,key,id,idBoard,idList;

    TRELLO(String token, String key, String id, String idBoard, String idList) {
        this.token = token;
        this.key = key;
        this.id = id;
        this.idBoard = idBoard;
        this.idList = idList;
    }

    public String getToken() {
        return token;
    }

    public String getKey() {
        return key;
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
