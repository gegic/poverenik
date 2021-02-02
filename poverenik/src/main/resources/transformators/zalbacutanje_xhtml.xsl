<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    body {
                    background-color: grey;
                    }
                    .c1 {
                    padding-left: 50pt;
                    margin: 0 auto;
                    margin-top: 20pt;
                    margin-bottom: 20pt;
                    background-color: white;
                    padding-right: 50pt;
                    padding-top: 60pt;
                    padding-bottom: 60pt;
                    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                    width: 40%;
                    position: sticky;
                    top: 25pt;
                    }
                    p {
                    margin-top:-6pt;
                    }

                </style>
            </head>
            <body>
                <div class="c1">
                    <p style="font-family:'Times New Roman';
						font-size:10pt;
						font-weight:bold;
						text-align:center;
						margin-top:48pt;">
                        ЖАЛБА КАДА ОРГАН ВЛАСТИ
                        <span style="font-family:'Times New Roman';
						font-size:10pt;
						font-weight:bold;
						text-align:center;
						margin-top:48pt;">
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
                        </span>
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:10pt;
						font-weight:bold;
						text-align:center;">
                        ТРАЖИОЦА У ЗАКОНСКОМ  РОКУ  (ЋУТАЊЕ УПРАВЕ)
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:12pt;
						text-align:left;
						margin-top:28pt;
						font-weight:bold;">
                        <xsl:value-of select="/zalba-cutanje/primalac/naziv"/>
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:left;">
                        Адреса за пошту:
                        <xsl:value-of select="/zalba-cutanje/primalac/adresa/mesto"/>,
                        <xsl:value-of select="/zalba-cutanje/primalac/adresa/ulica"/>
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:justify;">
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
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:center;
						margin-top:12pt;
						font-weight:bold;">
                        Ж А Л Б У
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:center;">
                        против
                    </p>
                    <p style="font-family: 'Times New Roman';
                    width: 100%;
                    margin-top: 11pt;
                    text-align: center;
                    border-bottom-style: dotted;
                    border-bottom-width: thin;">
                        <xsl:value-of select="/zalba-cutanje/protiv/naziv"/>
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:center;
						font-weight:bold;">
                        (навести назив органа)
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:center;
						margin-top:15pt;">
                        због тога што орган власти:
                    </p>
                    <p style="font-size:11pt;
						font-family:'Times New Roman';
						margin-top:2pt;
						text-align:center;">
                        <xsl:choose>
                            <xsl:when test="/zalba-cutanje/razlog/nepostupanje">
                                <span style="font-size:12pt;
						font-family:MS Gothic">
                                    <span style="font-weight:bold;
						font-size:11pt;
						font-family:'Times New Roman'">
                                        <span style="font-weight:bold;
						font-size:11pt;
						font-family:'Times New Roman';
						text-align:center;"><u>није поступио</u></span> / није поступио у целости /  у законском року
                                    </span>
                                </span>
                            </xsl:when>
                            <xsl:when test="/zalba-cutanje/razlog/nepostupanje-u-celosti">
                                <span style="font-size:11pt;
						font-weight:bold;
						font-family:'Times New Roman';">
                                    није поступио / <span style="font-size:11pt;
						font-weight:bold;
						text-align:center;
						font-family:'Times New Roman';
                        text-decoration:underline;"><u>није поступио у целости</u></span> / у законском року
                                </span>
                            </xsl:when>
                            <xsl:when test="/zalba-cutanje/razlog/nepostupanje-u-roku">
                                <span style="font-size:11pt;
						font-weight:bold;
						font-family:'Times New Roman';">
                                    није поступио / није поступио у целости /<span style="font-weight:bold;
						text-align:center;
						font-size:11pt;
						font-family:'Times New Roman';
                        text-decoration:underline;"><u>у законском року</u></span>
                                </span>
                            </xsl:when>
                        </xsl:choose>
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:center;">
                        (подвући  због чега се изјављује жалба)
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:justify;
						margin-top:10pt;">
                        по мом захтеву  за слободан приступ информацијама од јавног значаја који сам поднео  том органу  дана
                        <span>
                            <xsl:value-of select="/zalba-cutanje/zahtev/datum"/>
                        </span>
                        године, а којим сам тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног
                        значаја омогући увид-копија документа који садржи информације  о /у вези са :
                    </p>
                    <p style="font-family: 'Times New Roman';
                    width: 100%;
                    margin-top: 11pt;
                    text-align: center;
                    border-bottom-style: dotted;
                    border-bottom-width: thin;">
                        <xsl:value-of select="/zalba-cutanje/zahtev/opis-zahteva"/>
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:center;">
                        (навести податке о захтеву и информацији/ама)
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:justify;
						margin-top:28pt;">
                        На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им  информацији/ма.
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:justify;">
                        Као доказ, уз жалбу достављам копију захтева са доказом о предаји органу власти.
                    </p>
                    <p style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:justify;">
                        <span style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:justify;">Напомена:</span>
                        Код жалбе због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти.
                    </p>
                    <div style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:right;
						margin-top:10pt;">
                        <p style="margin-bottom:-7pt;"><xsl:value-of select="/zalba-cutanje/podnosilac/ime-prezime"/></p>
                        <p style="font-size:11pt;
                        text-align:right;
                        margin-bottom:2pt;">.........................................................................</p>
                        <p>Подносилац жалбе / Име и презиме</p>
                    </div>
                    <div style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:right;
						margin-top:10pt;">
                        <p style="margin-bottom:-7pt;"><xsl:value-of select="/zalba-cutanje/podnosilac/adresa/mesto"/>,
                            <xsl:value-of select="/zalba-cutanje/podnosilac/adresa/ulica"/></p>
                        <p style="font-size:11pt;
                        text-align:right;
                        margin-bottom:2pt;">.........................................................................</p>
                        <p>адреса</p>
                    </div>
                    <div style="font-family:'Times New Roman';
						font-size:11pt;
						text-align:right;
						margin-top:10pt;">
                        <p style="margin-bottom:-7pt;">
                            <xsl:choose>
                                <xsl:when test="/zalba-cutanje/podnosilac/ostali-podaci">
                                    <xsl:value-of select="/zalba-cutanje/podnosilac/ostali-podaci"/>
                                </xsl:when>
                                <xsl:otherwise>/</xsl:otherwise>
                            </xsl:choose>
                        </p>
                        <p style="font-size:11pt;
                        text-align:right;
                        margin-bottom:2pt;">.........................................................................</p>
                        <p>други подаци за контакт</p>
                    </div>
                    <p style="text-align:left;
						margin-top:10pt;
						font-family:'Times New Roman';
						font-size:11pt;">
                        У <span style="text-decoration:underline;" ><xsl:value-of select="/zalba-cutanje/mesto"/></span>,
                        <span style="text-decoration:underline;"><xsl:value-of select="/zalba-cutanje/datum"/></span>.
                    </p>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>