<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format"
        xmlns:ob="http://team14.xml.com/rdf/zahtevi"
        xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="bookstore-page">
                    <fo:region-body margin-top="0.75in"
                                    margin-bottom="0.75in" margin-left="80pt" margin-right="80pt" />
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="bookstore-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Times New Roman" margin-top="30pt"
                              font-size="11pt" text-align="left">
                        <xsl:value-of select="/obavestenje/organ/naziv"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                              font-size="11pt">
                        <xsl:value-of select="/obavestenje/organ/adresa/ulica"/>,
                        <xsl:value-of select="/obavestenje/organ/adresa/mesto"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                              font-size="11pt">
                        (назив и седиште органа)
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                              font-size="11pt">
                        Број предмета:
                        <xsl:value-of select="/obavestenje/broj"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                              font-size="11pt">
                        Датум:
                        <fo:inline text-indent="8em">
                            <xsl:value-of select="/obavestenje/datum"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                              font-size="11pt" margin-top="11pt">
                        <xsl:value-of select="/obavestenje/podnosilac/naziv"/>
                        <xsl:value-of select="/obavestenje/podnosilac/ime-prezime"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                              font-size="11pt">
                        <xsl:value-of select="/obavestenje/podnosilac/adresa/ulica"/>,
                        <xsl:value-of select="/obavestenje/podnosilac/adresa/mesto"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                              font-size="11pt">
                        Име и презиме / назив / и адреса подносиоца захтева
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                              text-align="center" font-size="12pt" margin-top="22pt"
                              font-weight="bold">
                        О Б А В Е Ш Т Е Њ Е
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                              text-align="center" font-size="11pt" font-weight="bold">
                        о стављању на увид документа који садржи
                        тражену информацију и о изради копије
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt"
                              text-align="justify" text-indent="4em" margin-top="28pt">
                        <xsl:for-each select="/obavestenje/zakon/clan">
                            <xsl:variable name="brojClana" select="@broj"/>
                            На основу члана <xsl:value-of select="$brojClana"/>.
                            <xsl:for-each select="stav">
                                <xsl:variable name="brojStava" select="@broj"/>
                                ст. <xsl:value-of select="$brojStava"/>.
                            </xsl:for-each>
                            <xsl:value-of select="/obavestenje/zakon/naziv"/>
                            („Службени гласник РС“, бр.
                            <xsl:for-each select="/obavestenje/zakon/sluzbeni-glasnik/broj">
                                <xsl:value-of select="."/>
                            </xsl:for-each>)
                        </xsl:for-each>, поступајући по вашем захтеву за слободан приступ информацијама од
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/obavestenje/zahtev/datum"/>
                        </fo:inline>
                        год., којим сте тражили увид у документ/е са информацијама о / у вези са:
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                              text-align="justify" font-size="11pt">
                        <xsl:value-of select="/obavestenje/zahtev/opis-zahteva"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                              text-align="center" font-size="11pt">
                        (опис тражене информације)
                    </fo:block>
                    <xsl:choose>
                        <xsl:when test="/obavestenje/sadrzaj-obavestenja/razlog-odbijanja">
                            <fo:block font-family="Times New Roman"
                                      text-align="justify" font-size="11pt" text-indent="4em"
                                      margin-top="11pt">
                            Oбавештавамо вас да је Ваш захтев одбијен из следећег разлога:
                            </fo:block>
                            <fo:block font-family="Times New Roman"
                                    text-align="justify" font-size="11pt" text-indent="4em"
                                    margin-top="11pt" text-decoration="underline">
                                    <xsl:value-of select="/obavestenje/sadrzaj-obavestenja/razlog-odbijanja"/>
                            </fo:block>
                        </xsl:when>
                        <xsl:when test="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev">
                            <fo:block font-family="Times New Roman"
                                      text-align="justify" font-size="11pt" text-indent="4em"
                                      margin-top="11pt">
                                Oбавештавамо вас да дана
                                <fo:inline text-decoration="underline">
                                    <xsl:value-of select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/datum"/>,
                                </fo:inline>
                                у
                                <xsl:choose>
                                    <xsl:when test="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/vreme/@zavrsetak">
                                        /
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <fo:inline text-decoration="underline">
                                            <xsl:value-of
                                                    select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/vreme/@pocetak"/>
                                        </fo:inline>
                                    </xsl:otherwise>
                                </xsl:choose>
                                часова,
                                односно у времену
                                <xsl:choose>
                                    <xsl:when test="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/vreme/@zavrsetak">
                                        од
                                        <fo:inline text-decoration="underline">
                                            <xsl:value-of
                                                    select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/vreme/@pocetak"/>
                                        </fo:inline>
                                        до
                                        <fo:inline text-decoration="underline">
                                            <xsl:value-of
                                                    select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/vreme/@zavrsetak"/>
                                        </fo:inline>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        од / до /
                                    </xsl:otherwise>
                                </xsl:choose>
                                часова, у просторијама органа у
                                <fo:inline text-decoration="underline">
                                    <xsl:value-of
                                            select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/adresa/mesto"/>
                                </fo:inline>
                                ул.
                                <fo:inline text-decoration="underline">
                                    <xsl:value-of
                                            select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/adresa/ulica"/>,
                                </fo:inline>
                                канцеларија бр.
                                <fo:inline text-decoration="underline">
                                    <xsl:value-of
                                            select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/kancelarija"/>
                                </fo:inline>
                                можете
                                <fo:inline font-weight="bold">извршити увид</fo:inline>
                                у документ/е у коме је садржана тражена
                                информација.
                            </fo:block>
                            <fo:block font-family="Times New Roman"
                                      text-align="justify" font-size="11pt" margin-top="11pt">
                                Трошкови су утврђени
                                <xsl:value-of select="/obavestenje/izdana-dokumenta/uredba/naziv"/>
                                („Сл. гласник
                                РС“, бр.
                                <xsl:for-each select="/obavestenje/izdana-dokumenta/uredba/sluzbeni-glasnik">
                                    <xsl:value-of select="broj"/>
                                </xsl:for-each>
                                ).
                                <xsl:if test="count(/obavestenje/izdana-dokumenta/cenovnik/stavka) > 0">
                                    И то:
                                    <xsl:for-each select="/obavestenje/izdana-dokumenta/cenovnik/stavka">
                                        <xsl:value-of select="@artikl"/> износи
                                        <xsl:value-of select="@cena"/>
                                        динара,
                                    </xsl:for-each>
                                    .
                                </xsl:if>
                            </fo:block>
                            <fo:block font-family="Times New Roman"
                                      text-align="justify" font-size="11pt" text-indent="4em"
                                      margin-top="11pt">
                                <xsl:if test="/obavestenje/izdana-dokumenta/cena > 0">
                                    Износ укупних трошкова износи
                                    <fo:inline text-decoration="underline">
                                        <xsl:value-of select="/obavestenje/izdana-dokumenta/cena"/>
                                    </fo:inline>
                                    динара
                                    и уплаћује се на жиро-рачун
                                    <fo:inline text-decoration="underline">
                                        <xsl:value-of select="/obavestenje/izdana-dokumenta/primalac/naziv"/>
                                    </fo:inline>
                                    бр.
                                    <fo:inline text-decoration="underline">
                                        <xsl:value-of select="/obavestenje/izdana-dokumenta/primalac/@broj-racuna"/>
                                    </fo:inline>
                                    , с позивом на број
                                    <fo:inline text-decoration="underline">
                                        <xsl:value-of select="/obavestenje/izdana-dokumenta/primalac/@model"/>
                                        <xsl:value-of select="/obavestenje/izdana-dokumenta/primalac/@poziv-na-broj"/>
                                    </fo:inline>
                                    (из
                                    Правилника о условима и начину вођења рачуна – „Сл. гласник
                                    РС“,
                                    20/07... 40/10).
                                </xsl:if>
                            </fo:block>
                        </xsl:when>
                    </xsl:choose>
                    <fo:block font-family="Times New Roman" text-align="left"
                              font-size="11pt" margin-top="11pt">
                        Достављено:
                        <fo:block>
                            <xsl:for-each select="obavestenje/dostavljeno/primalac">
                                <xsl:value-of select="position()"/>. <xsl:value-of select="."/>
                            </xsl:for-each>
                        </fo:block>
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                              text-align="center" font-size="11pt" margin-top="-15pt">
                        (М.П.)
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>