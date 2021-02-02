<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format"
        xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="zalba-cutanje-page">
                    <fo:region-body margin-top="0.75in"
                                    margin-bottom="0.75in" margin-left="80pt" margin-right="80pt" />
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="zalba-cutanje-page">
                <fo:flow flow-name="xsl-region-body">

                    <fo:block font-family="Times New Roman" font-size="10pt"
                              font-weight="bold" text-align="center" margin-top="48pt">
                        ЖАЛБА КАДА ОРГАН ВЛАСТИ
                        <fo:inline  font-family="Times New Roman" font-size="10pt"
                                    font-weight="bold" text-align="center" margin-top="48pt" border-after-style="solid">
                            НИЈЕ ПОСТУПИО/
                            <xsl:choose>
                                <xsl:when test="/zalba-cutanje/razlog/nepostupanje">
                                    није поступио
                                </xsl:when>
                                <xsl:when test="/zalba-cutanje/razlog/nepostupanje-u-celosti">
                                    није поступио у целости
                                </xsl:when>
                                <xsl:when test="/zalba-cutanje/razlog/nepostupanje-u-roku">
                                    у законском року
                                </xsl:when>
                            </xsl:choose>
                            / ПО ЗАХТЕВУ
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                              font-weight="bold" text-align="center">
                        ТРАЖИОЦА У ЗАКОНСКОМ  РОКУ  (ЋУТАЊЕ УПРАВЕ)
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt"
                              text-align="left" margin-top="28pt" font-weight="bold">
                        <xsl:value-of select="/zalba-cutanje/primalac/naziv"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="left">
                        Адреса за пошту:
                        <xsl:value-of select="/zalba-cutanje/primalac/adresa/mesto"/>,
                        <xsl:value-of select="/zalba-cutanje/primalac/adresa/ulica"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="justify">
                        У складу са чланом
                        <xsl:for-each select="/zalba-cutanje/zakon/clan">
                            <xsl:variable name="brojClana" select="@broj"/>
                            <xsl:value-of select="$brojClana"/>.
                            <xsl:for-each select="stav">
                                <xsl:variable name="brojStava" select="@broj"/>
                                ст. <xsl:value-of select="$brojStava"/>.
                            </xsl:for-each>
                            <xsl:value-of select="/zalba-cutanje/zakon/naziv"/>
                            („Службени гласник РС“, бр.
                            <xsl:for-each select="/zalba-cutanje/zakon/sluzbeni-glasnik/broj">
                                <xsl:value-of select="."/>
                            </xsl:for-each>)
                        </xsl:for-each> подносим:
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="center" margin-top="12pt" font-weight="bold">
                        Ж А Л Б У
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="center">
                        против
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                              margin-top="11pt" text-align="center" border-bottom-style="dotted">
                        <xsl:value-of select="/zalba-cutanje/protiv/naziv"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="center" font-weight="bold">
                        (навести назив органа)
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="center" margin-top="15pt">
                        због тога што орган власти:
                    </fo:block>
                    <fo:block font-size="11pt" font-family="Times New Roman" margin-top="2pt" text-align="center">
                    <xsl:choose>
                        <xsl:when test="/zalba-cutanje/razlog/nepostupanje">
                            <fo:inline font-size="12pt" font-family="MS Gothic">
                                <fo:inline font-weight="bold" font-size="11pt" font-family="Times New Roman" text-align="center">
                                    <fo:inline font-weight="bold" font-size="11pt" font-family="Times New Roman" text-align="center" text-decoration="underline">није поступио</fo:inline> / није поступио у целости /  у законском року
                                </fo:inline>
                            </fo:inline>
                        </xsl:when>
                        <xsl:when test="/zalba-cutanje/razlog/nepostupanje-u-celosti">
                            <fo:inline font-size="11pt" font-weight="bold" font-family="Times New Roman" text-align="center">
                                није поступио / <fo:inline font-size="11pt" font-weight="bold" text-align="center" font-family="Times New Roman" text-decoration="underline">није поступио у целости</fo:inline> / у законском року
                            </fo:inline>
                        </xsl:when>
                        <xsl:when test="/zalba-cutanje/razlog/nepostupanje-u-roku">
                            <fo:inline font-size="11pt" font-weight="bold" font-family="Times New Roman" text-align="center">
                                није поступио / није поступио у целости /<fo:inline font-weight="bold" text-align="center" font-size="11pt" font-family="Times New Roman" text-decoration="underline">у законском року</fo:inline>
                            </fo:inline>
                        </xsl:when>
                    </xsl:choose>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="center">
                        (подвући  због чега се изјављује жалба)
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="justify" margin-top="10pt">
                        по мом захтеву  за слободан приступ информацијама од јавног значаја који сам поднео  том органу  дана
                        <fo:inline>
                            <xsl:value-of select="/zalba-cutanje/zahtev/datum"/>
                        </fo:inline>
                        године, а којим сам тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног
                        значаја омогући увид-копија документа који садржи информације  о /у вези са :
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                              margin-top="11pt" text-align="center" border-bottom-style="dotted">
                        <xsl:value-of select="/zalba-cutanje/zahtev/opis-zahteva"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="center">
                        (навести податке о захтеву и информацији/ама)
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="justify" margin-top="28pt">
                        На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им  информацији/ма.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="justify" >
                        Као доказ, уз жалбу достављам копију захтева са доказом о предаји органу власти.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                              text-align="justify">
                        <fo:inline font-family="Times New Roman" font-size="11pt"
                                   text-align="justify" font-weight="bold">Напомена:</fo:inline>
                        Код жалбе због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" margin-top="10pt" margin-bottom="-7pt">
                        <xsl:value-of select="/zalba-cutanje/podnosilac/ime-prezime"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" margin-bottom="3pt" >
                        <fo:block font-size="11pt" text-align="right">.........................................................................</fo:block>
                        Подносилац жалбе / Име и презиме
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" margin-top="3pt"  margin-bottom="-7pt">
                        <xsl:value-of select="/zalba-cutanje/podnosilac/adresa/mesto"/>,
                        <xsl:value-of select="/zalba-cutanje/podnosilac/adresa/ulica"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" >
                        <fo:block font-size="11pt" text-align="right">.........................................................................</fo:block>
                        адреса
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" margin-top="3pt"  margin-bottom="-7pt">
                        <xsl:value-of select="/zalba-cutanje/podnosilac/ostali-podaci"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" >
                        <fo:block font-size="11pt" text-align="right">.........................................................................</fo:block>
                        други подаци за контакт
                    </fo:block>
                    <fo:block text-align="left" margin-top="10pt" font-family="Times New Roman" font-size="11pt">
                        У <fo:inline  text-decoration="underline" ><xsl:value-of select="/zalba-cutanje/mesto"/></fo:inline>,
                        <fo:inline text-decoration="underline"><xsl:value-of select="/zalba-cutanje/datum"/></fo:inline>.
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>