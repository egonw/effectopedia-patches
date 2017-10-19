package org.qsari.effectopedia.data.aopxml.objects

enum class WikiStatus(val value: String) {
    OpenForCitationComment("Open for citation & comment"),
    OpenForCommentDoNotCite("Open for comment. Do not cite"),
    OpenForAdoption("Open for adoption"),
    NotUnderActiveDevelopment("Not under active development"),
    UnderDevelopmentNotOpenForCommentDoNotCite("Under development: Not open for comment. Do not cite")
}

enum class OecdStatus(val value: String) {
    TFHAWNTEndorsed("TFHA/WNT Endorsed"),
    EAGMSTApproved("EAGMST Approved"),
    EAGMSTUnderReview("EAGMST Under Review"),
    UnderDevelopment("Under Development")
}

enum class SaaopStatus(val value: String) {
    IncludedInOECDWorkPlan("Included in OECD Work Plan"),
    ProposedForOECDWorkPlan("Proposed for OECD Work Plan"),
    UnderDevelopment("Under Development"),
    Archived("Archived")
}

enum class LifeStage(val value: String) {
    BirthToLessThanOneMonth("Birth to < 1 month"),
    OneToLessThanThreeMonths("1 to < 3 months"),
    ThreeToLessThanSixMonths("3 to < 6 months"),
    SixToLessThanTwelveMonths("6 to < 12 months"),
    OneToLessThanTwoYears("1 to < 2 years"),
    TwoToLessThanThreeYears("2 to < 3 years"),
    ThreeToLessThanSixYears("3 to < 6 years"),
    SixToLessThanElevenYears("6 to < 11 years"),
    ElevenToLessThanSixteenYears("11 to < 16 years"),
    SixteenToLessThanTwentyOneYears("16 to < 21 years"),
    NursingChild("Nursing Child"),
    Pregnancy("Pregnancy"),
    OldAge("Old Age"),
    NotOtherwiseSpecified("Not Otherwise Specified"),
    LactatingMother("Lactating Mother"),
    ConceptionToPrefetal("Conception to < Fetal"),
    FetalToParturition("Fetal to Parturition"),
    Foetal("Foetal"),
    Embryo("Embryo"),
    Juvenile("Juvenile"),
    AdultReproductivelyMature("Adult, reproductively mature"),
    Perinatal("Perinatal"),
    DuringDevelopmentAndAtAdulthood("During development and at adulthood"),
    Adults("Adults"),
    Adult("Adult"),
    DuringBrainDevelopmentAdulthoodAndAging("During brain development, adulthood and aging"),
    DuringBrainDevelopment("During brain development"),
    Human("Human"),
    Development("Development"),
    AllLifeStages("All life stages"),
    Fetal("Fetal")
}
