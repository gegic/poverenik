<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                version="2.0">
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
                    margin-top: -6pt;
                    }
                </style>
            </head>
            <body>
                <div class="c1">
                    <div style="font-family:Times New Roman;
							font-size:10pt;
							font-weight:bold;
							text-align:center;
							margin-top:48pt;">
                        ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ
                        <span style="font-family:Times New Roman;
							font-size:10pt;
							font-weight:bold;
							text-align:center;
							margin-top:48pt;
							border-after-style:solid">
                            ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ
                        </span>
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:10pt;
							font-weight:bold;
							text-align:center">
                        ЗА ПРИСТУП ИНФОРМАЦИЈИ
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:12pt;
							text-align:left;
							margin-top:28pt;
							font-weight:bold;">
                        <xsl:value-of select="/zalba-na-odluku/primalac/naziv"/>
                    </div>
                    <div style="font-family:Times New Roman;font-size:11pt;
							text-align:left;">
                        Адреса за пошту: <xsl:value-of select="/zalba-na-odluku/primalac/adresa/mesto"/>,
                        <xsl:value-of select="/zalba-na-odluku/primalac/adresa/ulica"/>
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:center;
							margin-top:12pt;
							font-weight:bold;">
                        Ж А Л Б А
                    </div>
                    <div font-family="Times New Roman" width="60%"
                              margin-top="11pt" text-align="center" border-bottom-style="dotted">
                        <span>
                            <xsl:value-of select="/zalba-na-odluku/podnosilac/ime-prezime"/>
                        </span>
                        ,
                        <span>
                            <xsl:value-of select="/zalba-na-odluku/podnosilac/adresa/ulica"/>
                        </span>
                        ,
                        <span>
                            <xsl:value-of select="/zalba-na-odluku/podnosilac/adresa/mesto"/>
                        </span>
    
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:center;
							font-weight:bold">
                        (Име, презиме, односно назив, адреса и седиште жалиоца)
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:center;
							margin-top:15pt">
                        против решења-закључка
                    </div>
                    <div font-family="Times New Roman" width="60%"
                              margin-top="11pt" text-align="center" border-bottom-style="dotted">
                        <xsl:value-of select="/zalba-na-odluku/protiv/donosilac/naziv"/>
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:center;
							font-weight:bold">
                        (назив органа који је донео одлуку)
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:justify;
							margin-top:10pt">
                        Број
                        <span>
                            <xsl:value-of select="/zalba-na-odluku/protiv/broj-obavestenja"/>
                        </span>
                        од
                        <span>
                            <xsl:value-of select="zalba-na-odluku/protiv/datum"/>
                        </span>
                        .
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:justify;
							margin-top:10pt">
                        Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми
                        са елементима одлуке), супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-
                        упутио/ла дана
                        <span>
                            <xsl:value-of select="zalba-na-odluku/zahtev/datum"/>
                        </span>
                        године и тако ми ускраћено-онемогућено остваривање уставног и
                        законског права на слободан приступ информацијама од јавног значаја. Oдлуку побијам
                        <xsl:choose>
                            <xsl:when test="zalba-na-odluku/deo-pobijanja = 'у целости'">
                                <span>
                                    у целости
                                </span>
                            </xsl:when>
                            <xsl:otherwise>
                                <span>
                                    у делу којим
                                </span>
                                <span style="text-decoration:underline;">
                                    <xsl:value-of select="zalba-na-odluku/deo-pobijanja"/>
                                </span>
                            </xsl:otherwise>
                        </xsl:choose>
                        јер није заснована на Закону о слободном приступу информацијама од јавног значаја.
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:justify;
							margin-top:28pt">
                        На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  поништи одлука првостепеног органа и омогући ми приступ траженој/им  информацији/ма.
                    </div>
                    <div style="font-family:Times New Roman;font-size:11pt;
							text-align:justify;">
                        Жалбу подносим благовремено, у законском року утврђеном у члану
                        <xsl:for-each select="/zalba-na-odluku/zakon/clan">
                            <xsl:variable name="brojClana" select="@broj"/>
                            <xsl:value-of select="$brojClana"/>.
                            <xsl:for-each select="stav">
                                <xsl:variable name="brojStava" select="@broj"/>
                                ст. <xsl:value-of select="$brojStava"/>.
                            </xsl:for-each>
                            <xsl:value-of select="/zalba-na-odluku/zakon/naziv"/>
                            („Службени гласник РС“, бр.
                            <xsl:for-each select="/zalba-na-odluku/zakon/sluzbeni-glasnik/broj">
                                <xsl:value-of select="."/>
                            </xsl:for-each>)
                        </xsl:for-each>
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:right;
							margin-top:10pt;
							margin-bottom:-7pt;">
                        <xsl:value-of select="/zalba-na-odluku/podnosilac/ime-prezime"/>
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:right;
							margin-bottom:3pt">
                        <div style="font-size:11pt;text-align:right;">.........................................................................</div>
                        Подносилац жалбе / Име и презиме
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:right;
							margin-top:3pt;
							margin-bottom:-7pt;">
                        <xsl:value-of select="/zalba-na-odluku/podnosilac/adresa/ulica"/>,
                        <xsl:value-of select="/zalba-na-odluku/podnosilac/adresa/mesto"/>
                    </div>
                    <div style="font-family:Times New Roman;font-size:11pt;
							text-align:right;">
                        <div style="font-size:11pt;text-align:right;">.........................................................................</div>
                        адреса
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:right;
							margin-top:3pt;
							margin-bottom:-7pt;">
                        <xsl:value-of select="/zalba-na-odluku/podnosilac/ostali-podaci"/>
                    </div>
                    <div style="font-family:Times New Roman;font-size:11pt;
							text-align:right;">
                        <div style="font-size:11pt;text-align:right;">.........................................................................</div>
                        други подаци за контакт
                    </div>
                    <div style="text-align:left;
							margin-top:10pt;
							font-family:Times New Roman;
							font-size:11pt">
                        У <span style="text-decoration:underline;"><xsl:value-of select="/zalba-na-odluku/mesto"/></span>, дана
                        <span style="text-decoration:underline;"><xsl:value-of select="/zalba-na-odluku/datum"/></span> године.
                    </div>
                    <div style="font-family:Times New Roman;
							font-size:11pt;
							text-align:justify;
							font-weight:bold">
                        Напомена:
                    </div>
                    <div style="font-family:Times New Roman;font-size:11pt;
							text-align:justify;">
                        •   У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив
                        органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац наведе у
                        жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити.
                        Ако жалбу изјављује на овом обрасцу, додатно образложење може  посебно приложити.
                    </div>
                    <div style="font-family:Times New Roman;font-size:11pt;
							text-align:justify;">
                        •   Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој предаји-упућивању органу
                        као и копију одлуке органа која се оспорава жалбом.
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>