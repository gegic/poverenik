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
					margin-left:auto;
					margin-right:auto;
					width: 169mm;
					position: sticky;
					top: 25pt;
                    min-height: 240mm;">
                    <p style="font-family:'Times New Roman';
					margin-top:30pt;
					font-size:11pt;
					text-align:left;
					margin-top:-10pt;">
                        <xsl:value-of select="/obavestenje/organ/naziv"/>
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:left;
					margin-top:-10pt;
					font-size:11pt;">
                        <xsl:value-of select="/obavestenje/organ/adresa/ulica"/>,
                        <xsl:value-of select="/obavestenje/organ/adresa/mesto"/>
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:left;
					margin-top:-10pt;
					font-size:11pt;">
                        (назив и седиште органа)
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:left;
					margin-top:-10pt;
					font-size:11pt;">
                        Број предмета:
                        <xsl:value-of select="/obavestenje/broj"/>
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:left;
					margin-top:-10pt;
					font-size:11pt;">
                        Датум:
                        <span style="text-indent:8em;">
                            <xsl:value-of select="/obavestenje/datum"/>
                        </span>
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:left;
					font-size:11pt;
					margin-top:11pt;">
                        <xsl:value-of select="/obavestenje/podnosilac/naziv"/>
                        <xsl:value-of select="/obavestenje/podnosilac/ime-prezime"/>
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:left;
					margin-top:-10pt;
					font-size:11pt;">
                        <xsl:value-of select="/obavestenje/podnosilac/adresa/ulica"/>,
                        <xsl:value-of select="/obavestenje/podnosilac/adresa/mesto"/>
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:left;
					margin-top:-10pt;
					font-size:11pt;">
                        Име и презиме / назив / и адреса подносиоца захтева
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:center;
					font-size:12pt;
					margin-top:22pt;
					font-weight:bold;">
                        О Б А В Е Ш Т Е Њ Е
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:center;
					font-size:11pt;
					font-weight:bold;">
                        о стављању на увид документа који садржи
                        тражену информацију и о изради копије
                    </p>
                    <p style="font-family:'Times New Roman';
					font-size:12pt;
					text-align:justify;
					text-indent:4em;
					margin-top:28pt;">
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
                        <span style="text-decoration:underline;">
                            <xsl:value-of select="/obavestenje/zahtev/datum"/>
                        </span>
                        год., којим сте тражили увид у документ/е са информацијама о / у вези са:
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:justify;
					font-size:11pt;">
                        <xsl:value-of select="/obavestenje/zahtev/opis-zahteva"/>
                    </p>
                    <p style="font-family:'Times New Roman';
					text-align:center;
					font-size:11pt;">
                        (опис тражене информације)
                    </p>
                    <xsl:choose>
                        <xsl:when test="/obavestenje/sadrzaj-obavestenja/razlog-odbijanja">
                            <p style="font-family:'Times New Roman';
                                text-align:justify;
                                font-size:11pt;
                                text-indent:4em;
                                margin-top:11pt;">
                                Oбавештавамо вас да је Ваш захтев одбијен из следећег разлога:
                            </p>
                            <p style="font-family:'Times New Roman';
                                text-align:justify;
                                font-size:11pt;
                                text-indent:4em;
                                margin-top:11pt;">
                                <u><xsl:value-of select="/obavestenje/sadrzaj-obavestenja/razlog-odbijanja"/></u>
                            </p>

                        </xsl:when>
                        <xsl:when test="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev">
                            <p style="font-family:'Times New Roman';
					text-align:justify;
					font-size:11pt;
					text-indent:4em;
					margin-top:11pt;">
                                Oбавештавамо вас да дана
                                <span style="text-decoration:underline;">
                                    <xsl:value-of select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/datum"/>,
                                </span>
                                у
                                <xsl:choose>
                                    <xsl:when test="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/vreme/@zavrsetak">
                                        /
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <span style="text-decoration:underline;">
                                            <xsl:value-of
                                                    select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/vreme/@pocetak"/>
                                        </span>
                                    </xsl:otherwise>
                                </xsl:choose>
                                часова,
                                односно у времену
                                <xsl:choose>
                                    <xsl:when test="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/vreme/@zavrsetak">
                                        од
                                        <span style="text-decoration:underline;">
                                            <xsl:value-of
                                                    select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/vreme/@pocetak"/>
                                        </span>
                                        до
                                        <span style="text-decoration:underline;">
                                            <xsl:value-of
                                                    select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/vreme/@zavrsetak"/>
                                        </span>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        од / до /
                                    </xsl:otherwise>
                                </xsl:choose>
                                часова, у просторијама органа у
                                <span style="text-decoration:underline;">
                                    <xsl:value-of
                                            select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/adresa/mesto"/>
                                </span>
                                ул.
                                <span style="text-decoration:underline;">
                                    <xsl:value-of
                                            select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/adresa/ulica"/>,
                                </span>
                                канцеларија бр.
                                <span style="text-decoration:underline;">
                                    <xsl:value-of
                                            select="/obavestenje/sadrzaj-obavestenja/prihvacen-zahtev/kancelarija"/>
                                </span>
                                можете
                                <span style="font-weight:bold;">извршити увид</span>
                                у документ/е у коме је садржана тражена
                                информација.
                            </p>
                            <p style="font-family:'Times New Roman';
					text-align:justify;
					font-size:11pt;
					margin-top:11pt;">
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
                            </p>
                            <p style="font-family:'Times New Roman';
					text-align:justify;
					font-size:11pt;
					text-indent:4em;
					margin-top:11pt;">
                                <xsl:if test="/obavestenje/izdana-dokumenta/cena > 0">
                                    Износ укупних трошкова износи
                                    <span style="text-decoration:underline;">
                                        <xsl:value-of select="/obavestenje/izdana-dokumenta/cena"/>
                                    </span>
                                    динара
                                    и уплаћује се на жиро-рачун
                                    <span style="text-decoration:underline;">
                                        <xsl:value-of select="/obavestenje/izdana-dokumenta/primalac/naziv"/>
                                    </span>
                                    бр.
                                    <span style="text-decoration:underline;">
                                        <xsl:value-of select="/obavestenje/izdana-dokumenta/primalac/@broj-racuna"/>
                                    </span>
                                    , с позивом на број
                                    <span style="text-decoration:underline;">
                                        <xsl:value-of select="/obavestenje/izdana-dokumenta/primalac/@model"/>
                                        <xsl:value-of select="/obavestenje/izdana-dokumenta/primalac/@poziv-na-broj"/>
                                    </span>
                                    (из
                                    Правилника о условима и начину вођења рачуна – „Сл. гласник
                                    РС“,
                                    20/07... 40/10).
                                </xsl:if>
                            </p>
                        </xsl:when></xsl:choose>
                    <p style="font-family:'Times New Roman';
					text-align:left;
					font-size:11pt;
					margin-top:11pt;">
                        Достављено:
                        <div>
                            <xsl:for-each select="obavestenje/dostavljeno/primalac">
                                <xsl:value-of select="position()"/>. <xsl:value-of select="."/>
                            </xsl:for-each>
                        </div>
                    </p>
                    <div style="margin-top:-20pt;
                                text-align:center;">
                        <p style="font-family:'Times New Roman'
                                  font-size:11pt;">
                            (М.П.)
                        </p>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>