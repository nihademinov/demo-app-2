package com.example.demoapp.api.model.constrants;

public class ValidationMessages {

    private ValidationMessages() {}



    public static final String NAME_SIZE_VALIDATION = "[2-64] arasi simvol daxil oluna biler";
    public static final String NAME_NOT_NULL_VALIDATION = "Ad bosh ola bilmez";


    public static final String ROLES_NOT_EMPTY_VALIDATION = "Ən azı bir istifadəçi rolu seçilməlidir";

    public static final String PHONE_NUMBER_VALIDATION = "Telefon nomresi duzgun qeyd olunmayib";

    public static final String EMAIL_NOT_NULL_VALIDATION = "Email hissesi boş ola bilməz";
    public static final String EMAIL_ALREADY_EXISTS = "Bu email ile artiq istifadeci movcuddur";
    public static final String EMAIL_VALIDATION = "[5-64] arasi simvol daxil etmek mumkundur";
    public static final String EMAIL_FORMAT_VALIDATION = "Email formatinda sehvlik var";

    public static final String USER_NOT_FOUND = "Istifadeci tapilmadi";

    public static final String ROLE_VALIDATION = "Role adlari duzgun yazilmayib";
    public static final String ROLE_SIZE_VALIDATION = "[3-64] arasi simvol daxil oluna biler ";

    public static final String BRAND_NOT_NULL_VALIDATION = "Nəqliyyat vasitesinin markasi bos ola bilmez";
    public static final String BRAND_SIZE_VALIDATION = "[3-64] arasi simvol daxil oluna bilər";

    public static final String MODEL_NOT_NULL_VALIDATION = "Nəqliyyat vasitesinin modeli boş ola bilmez";
    public static final String MODEL_SIZE_VALIDATION = "[3-64] arasi simvol daxil oluna bilər";

    public static final String COLOR_NOT_NULL_VALIDATION = "Rəng hissəsi boş ola bilməz";
    public static final String COLOR_SIZE_VALIDATION = "[1-15] arasi simvol daxil oluna bilər";

    public static final String ENGINE_NOT_NULL_VALIDATION = "Mühərrikin həcm hissesi boş ola bilməz";
    public static final String ENGINE_MIN_SIZE_VALIDATION = "0 dan kiçik həcm daxil edilə bilməz";
    public static final String ENGINE_MAX_SIZE_VALIDATION = "16.0 dan böyük həcm daxil edilə bilməz";

    public static final String MILEAGE_NOT_NULL_VALIDATION = "Yürüyüş bos ola bilmez";
    public static final String MILEAGE_SIZE_VALIDATION = "Yürüyüş minimum 0 ola biler";

    public static final String PRICE_NOT_NULL_VALIDATION = "Qiymet bos ola bilmez";
    public static final String PRICE_VALUE_VALIDATION = "Qiymet  0 dan boyuk olmalidir";

    public static final String VEHICLE_NOT_FOUND = "Nəqliyyat vasitəsi tapılmadı";

    public static final String ORDER_NOT_FOUND = "Sifaris tapılmadı";
    public static final String ORDER_NOT_ACTIVE_FOUND = "Hal hazırda aktiv sifaris tapılmadı";

    public static final String ID_NOT_NULL = "Id bos ola bilmez";

    public static final String DATRE_NOT_NULL = "Tarix bos ola bilmez";
    public static final String DATRE_NOT_BE_LAST = "Rezervasiya uchun kecmis tarix yazila bilmez";





}
