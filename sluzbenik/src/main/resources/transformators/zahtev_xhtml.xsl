<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:z="http://team14.xml.com/rdf/zahtevi"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    body {
                        background-color: grey;
                    }
                </style>
            </head>
            <body>
                <div style="padding-left: 50pt;
					margin: 0 auto;
					margin-top: 20pt;
					margin-bottom: 20pt;
					background-color: white;
					padding-right: 50pt;
					padding-top: 60pt;
					padding-bottom: 60pt;
					box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
					margin-left:265pt;
					margin-right:265pt;
					position: sticky;
					top: 25pt;">
                    <p style="font-family: 'Times New Roman';
					margin-top: 10pt;
					text-align: center;">
                        <xsl:value-of select="/zahtev/organ/naziv"/>,
                        <xsl:value-of select="/zahtev/organ/adresa/ulica"/>,
                        <xsl:value-of select="/zahtev/organ/adresa/mesto"/>
                    </p>
                    <p style="text-align:center;font-size:12pt;font-family:'Times New Roman';margin-top:-10pt;">назив и седиште органа коме се захтев упућује</p>
                    <p style="font-family: 'Times New Roman';
					font-size: 14pt;
					text-align: center;
					margin-top:48pt;">
                        <strong>З А Х Т Е В</strong>
                    </p>
                    <p style="font-family: 'Times New Roman';
					font-size: 14pt;
					text-align: center;
					margin-top: -10pt;">
                        <strong>за приступ информацији од јавног значаја</strong>
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-align:justify;
					text-indent:4em;
					margin-top:28pt;">
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
                            </xsl:for-each>), од горе наведеног органа захтевам:*
                        </xsl:for-each>
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-indent:4em;
					margin-top:12pt;">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/obavestenje-posedovanja-informacije">
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </span>
                            </xsl:when>
                            <xsl:otherwise>
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </span>
                            </xsl:otherwise>
                        </xsl:choose>
                        обавештење да ли поседује тражену информацију;
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-indent:4em;
					margin-top:-10pt;">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/uvid-u_dokument">
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </span>
                            </xsl:when>
                            <xsl:otherwise>
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </span>
                            </xsl:otherwise>
                        </xsl:choose>
                        увид у документ који садржи тражену информацију;
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-indent:4em;
					margin-top:-10pt;">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/kopiju-dokumenta">
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </span>
                            </xsl:when>
                            <xsl:otherwise>
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </span>
                            </xsl:otherwise>
                        </xsl:choose>
                        копију документа који садржи тражену информацију;
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-indent:4em;
					margin-top:-10pt;">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/dostavljanje-kopije">
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </span>
                            </xsl:when>
                            <xsl:otherwise>
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </span>
                            </xsl:otherwise>
                        </xsl:choose>
                        достављање копије документа који садржи тражену информацију:**
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-indent:8em;
					margin-top:-10pt;">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/dostavljanje-kopije/posta">
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </span>
                            </xsl:when>
                            <xsl:otherwise>
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </span>
                            </xsl:otherwise>
                        </xsl:choose>
                        поштом
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-indent:8em;
					margin-top:-10pt;">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/dostavljanje-kopije/faks">
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </span>
                            </xsl:when>
                            <xsl:otherwise>
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </span>
                            </xsl:otherwise>
                        </xsl:choose>
                        факсом
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-indent:8em;
					margin-top:-10pt;">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/dostavljanje-kopije/eposta">
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </span>
                            </xsl:when>
                            <xsl:otherwise>
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </span>
                            </xsl:otherwise>
                        </xsl:choose>
                        електронском поштом
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-indent:8em;
					margin-top:-10pt;">
                        <xsl:choose>
                            <xsl:when
                                    test="/zahtev/tip-zahteva/dostavljanje-kopije/drugi-nacin">
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☑
                                </span>
                            </xsl:when>
                            <xsl:otherwise>
                                <span font-size="12pt" font-family="MS Gothic">
                                    ☐
                                </span>
                            </xsl:otherwise>
                        </xsl:choose>
                        на други начин:***
                        <xsl:value-of select="/zahtev/tip-zahteva/dostavljanje-kopije/drugi-nacin"/>
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-align:justify;
					text-indent:4em;">
                        Овај захтев се
                        односи на следеће информације:
                    </p>
                    <p style="margin-top:-10pt;
					font-family:'Times New Roman';
					font-size:12pt;
					text-align:justify;
					text-indent:4em;">
                        <xsl:value-of select="/zahtev/opis-zahteva"/>
                    </p>
                    <p style="margin-top:-10pt;
					font-family:'Times New Roman';
					font-size:9pt;
					text-align:justify;">(навести што прецизнији опис
                        информације која се
                        тражи
                        као
                        и друге податке који олакшавају
                        проналажење тражене
                        информације)</p>
                    <p style="font-family:'Times New Roman';
					font-size:10pt;
					text-align:right;
					margin-top:27pt;">
                        <xsl:value-of select="/zahtev/trazilac-informacije/ime-prezime"/>
                    </p>
                    <p style="text-align:right;
					font-size: 10pt;
					font-family: 'Times New Roman';
					margin-top:-10pt;">Тражилац информације/Име и презиме</p>
                    <p style="font-family:'Times New Roman';
					font-size:10pt;
					text-align:right;">
                        <xsl:value-of select="/zahtev/trazilac-informacije/adresa/ulica"/>,
                        <xsl:value-of select="/zahtev/trazilac-informacije/adresa/mesto"/>
                    </p>
                    <p style="text-align:right;
					font-size: 10pt;
					font-family: 'Times New Roman';
					margin-top:-10pt;">адресa</p>
                    <p style="font-family:'Times New Roman';
					font-size:10pt;
					text-align:right;">
                        <xsl:value-of select="/zahtev/trazilac-informacije/ostali-podaci"/>
                    </p>
                    <p style="text-align:right;
					font-size: 10pt;
					font-family: 'Times New Roman';
					margin-top:-10pt;">други подаци за контакт</p>
                    <p style="font-family:'Times New Roman';
					font-size:10pt;
					text-align:left;
					margin-top:-50pt;">
                        У
                        <xsl:value-of select="/zahtev/mesto"/>,

                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:10pt;
					text-align:left;
					margin-top:20pt;">
                        дана
                        <xsl:value-of select="/zahtev/datum"/>
                    </p>
                    <p style="font-family: 'Times New Roman';
					font-size: 9pt;
					margin-top: 40pt;
					text-align:justify;">__________________________________________</p>
                    <p style="font-family: 'Times New Roman';
					font-size:9pt;
					margin-top: -10pt;
					text-align:justify;">* У кућици означити која законска права на приступ
                        информацијама желите да остварите.</p>
                    <p style="font-family: 'Times New Roman';
					font-size:9pt;
					margin-top: -10pt;
					text-align:justify;">** У кућици означити начин достављања копије
                        докумената.</p>
                    <p style="font-family: 'Times New Roman';
					font-size:9pt;
					margin-top: -10pt;
					text-align:justify;">*** Када захтевате други начин достављања обавезно
                        уписати који начин достављања захтевате.</p>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>