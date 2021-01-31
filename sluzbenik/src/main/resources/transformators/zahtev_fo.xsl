<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format"
        xmlns:z="http://team14.xml.com/rdf/zahtevi"
        xmlns:xs="http://www.w3.org/2001/XMLSchema"
        version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="zahtev-page">
                    <fo:region-body margin-top="0.75in"
                                    margin-bottom="0.75in" margin-left="80pt" margin-right="80pt" />
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="zahtev-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Times New Roman" width="60%"
                              margin-top="10pt" text-align="center" border="none">
                        <xsl:value-of
                                select="/zahtev/organ/naziv"/>,
                        <xsl:value-of
                                select="/zahtev/organ/adresa/ulica"/>,
                        <xsl:value-of
                                select="/zahtev/organ/adresa/mesto"/>
                    </fo:block>
                    <fo:block margin-top="0pt" margin-bottom="0pt"
                              text-align="center" font-size="12pt" font-family="Times New Roman">
                        назив и седиште
                        органа коме се захтев упућује
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="14pt"
                              font-weight="bold" text-align="center" margin-top="48pt">
                        З А Х Т Е В
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="14pt"
                              font-weight="bold" text-align="center">
                        за приступ информацији од јавног
                        значаја
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt"
                              text-align="justify" text-indent="4em" margin-top="28pt">
                        <xsl:for-each select="/zahtev/zakon/clan">
                            <xsl:variable name="brojClana" select="@broj"/>
                            На основу члана <xsl:value-of select="$brojClana"/>.
                            <xsl:for-each select="stav">
                                <xsl:variable name="brojStava" select="@broj"/>
                                ст. <xsl:value-of select="$brojStava"/>.
                            </xsl:for-each>
                            <xsl:value-of select="/zahtev/zakon/naziv"/>
                            („Службени гласник РС“, бр.
                            <xsl:for-each select="/zahtev/zakon/sluzbeni-glasnik">
                               <xsl:value-of select="broj"/> 
                            </xsl:for-each>
                            ), од горе наведеног органа захтевам:*
                        </xsl:for-each>

                    </fo:block>
                    <fo:block text-indent="4em" font-size="12pt"
                              font-family="Times New Roman" margin-top="12pt">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/obavestenje-posedovanja-informacije">
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </fo:inline>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </fo:inline>
                            </xsl:otherwise>
                        </xsl:choose>
                        обавештење да ли поседује тражену информацију;
                    </fo:block>
                    <fo:block text-indent="4em" font-size="12pt"
                              font-family="Times New Roman">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/uvid-u_dokument">
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </fo:inline>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </fo:inline>
                            </xsl:otherwise>
                        </xsl:choose>
                        увид у документ који садржи тражену информацију;
                    </fo:block>
                    <fo:block text-indent="4em" font-size="12pt"
                              font-family="Times New Roman">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/kopiju-dokumenta">
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </fo:inline>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </fo:inline>
                            </xsl:otherwise>
                        </xsl:choose>
                        копију документа који садржи тражену информацију;
                    </fo:block>
                    <fo:block text-indent="4em" font-size="12pt"
                              font-family="Times New Roman">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/dostavljanje-kopije">
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </fo:inline>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </fo:inline>
                            </xsl:otherwise>
                        </xsl:choose>
                        достављање копије документа који садржи тражену информацију:**
                    </fo:block>
                    <fo:block text-indent="8em" font-size="12pt"
                              font-family="Times New Roman">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/dostavljanje-kopije/posta">
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </fo:inline>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </fo:inline>
                            </xsl:otherwise>
                        </xsl:choose>
                        поштом
                    </fo:block>
                    <fo:block text-indent="8em" font-size="12pt"
                              font-family="Times New Roman">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/dostavljanje-kopije/faks">
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </fo:inline>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </fo:inline>
                            </xsl:otherwise>
                        </xsl:choose>
                        факсом
                    </fo:block>
                    <fo:block text-indent="8em" font-size="12pt"
                              font-family="Times New Roman">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/dostavljanje-kopije/eposta">
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </fo:inline>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </fo:inline>
                            </xsl:otherwise>
                        </xsl:choose>
                        електронском поштом
                    </fo:block>
                    <fo:block text-indent="8em" font-size="12pt"
                              font-family="Times New Roman">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/dostavljanje-kopije/drugi-nacin">
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </fo:inline>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:inline font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </fo:inline>
                            </xsl:otherwise>
                        </xsl:choose>
                        на други начин:***
                        <xsl:value-of
                                select="/zahtev/tip-zahteva/dostavljanje-kopije/drugi-nacin"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt"
                              text-align="justify" text-indent="4em" margin-top="12pt">
                        Овај захтев се
                        односи на следеће
                        информације:
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt"
                              text-align="justify" text-indent="4em">
                        <xsl:value-of
                                select="/zahtev/opis-zahteva"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                              text-align="justify">
                        (навести што прецизнији опис информације која се тражи
                        као и друге податке
                        који олакшавају проналажење тражене
                        информације)
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                              text-align="right" margin-top="27pt">
                        <xsl:value-of
                                select="/zahtev/trazilac-informacije/ime-prezime"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                              text-align="right">
                        Тражилац информације/Име и презиме
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                              text-align="right" margin-top="10pt">
                        <xsl:value-of
                                select="/zahtev/trazilac-informacije/adresa/ulica"/>,
                        <xsl:value-of
                                select="/zahtev/trazilac-informacije/adresa/mesto"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                              text-align="right">
                        адреса
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                              text-align="right" margin-top="10pt">
                        <xsl:value-of
                                select="/zahtev/trazilac-informacije/ostali-podaci"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                              text-align="right">
                        други подаци за контакт
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                              text-align="left" margin-top="-50pt">
                        У
                        <xsl:value-of
                                select="/zahtev/mesto"/>,
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                              text-align="left" margin-top="20pt">
                        дана
                        <xsl:value-of select="/zahtev/datum"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                              text-align="justify" margin-top="40pt">
                        __________________________________________
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                              text-align="justify">
                        * У кућици означити која законска права на приступ
                        информацијама желите да остварите.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                              text-align="justify">
                        ** У кућици означити начин достављања копије
                        докумената.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                              text-align="justify">
                        *** Када захтевате други начин достављања обавезно
                        уписати који начин достављања захтевате.
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>