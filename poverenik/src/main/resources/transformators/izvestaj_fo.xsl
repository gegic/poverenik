<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format"
        version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="izvestaj-page">
                    <fo:region-body margin-top="0.75in"
                                    margin-bottom="0.75in" margin-left="80pt" margin-right="80pt" />
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="izvestaj-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Arial" width="60%"
                              margin-top="10pt" text-align="center" border="none">
                        Primena Zakona o slobodnom pristupu informacijama od javnog značaja u
                        <xsl:value-of select="/izvestaj/godisnja-statistika/@godina"/>.god.
                    </fo:block>
                    <fo:block font-family="Arial" width="60%"
                              margin-top="10pt" text-align="left" border="none">
                        1. Zahtevi:
                    </fo:block>
                    <fo:table margin-top="10pt" border="solid 0.4mm black">
                        <fo:table-header>
                            <fo:table-row>
                                <fo:table-cell border="solid 0.1mm black" padding-top="1mm" text-align="center">
                                    <fo:block font-weight="bold">
                                        Red.
                                        broj
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding-top="1mm" text-align="center">
                                    <fo:block font-weight="bold">
                                        Tražilac informacije
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding-top="1mm" text-align="center">
                                    <fo:block font-weight="bold">
                                        Broj podnetih zahteva
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding-top="1mm" text-align="center">
                                    <fo:block font-weight="bold">
                                        Broj prihvacenih zahteva
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black"  padding-top="1mm" text-align="center">
                                    <fo:block font-weight="bold">
                                        Broj odbijenih zahteva
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="/izvestaj/trazilac-informacije">
                                <fo:table-row>
                                    <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                        <fo:block>
                                            <xsl:value-of select="position()"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                        <fo:block>
                                            <xsl:value-of select="naziv"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                        <fo:block>
                                            <xsl:variable name="prihvaceniZahtevi" select="zahtevi/@prihvaceni"/>
                                            <xsl:variable name="odbijeniZahtevi" select="zahtevi/@odbijeni"/>
                                            <xsl:value-of select="$prihvaceniZahtevi + $odbijeniZahtevi"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                        <fo:block>
                                            <xsl:value-of select="zahtevi/@prihvaceni"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                        <fo:block>
                                            <xsl:value-of select="zahtevi/@odbijeni"/>
                                        </fo:block>
                                    </fo:table-cell>

                                </fo:table-row>
                            </xsl:for-each>
                            <fo:table-row>
                                <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                    <fo:block font-weight="bold">
                                        Ukupno
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                    <fo:block font-weight="bold">
                                        <xsl:variable name="prihvaceniZahtevi"
                                                      select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi"/>
                                        <xsl:variable name="odbijeniZahtevi"
                                                      select="/izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                                        <xsl:value-of select="$prihvaceniZahtevi + $odbijeniZahtevi"/>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                    <fo:block font-weight="bold">
                                        <xsl:value-of select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi"/>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                    <fo:block font-weight="bold">
                                        <xsl:value-of select="/izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                    <fo:block font-family="Arial" width="60%"
                              margin-top="25pt" text-align="left" border="none">
                        2. Žalbe:
                    </fo:block>
                    <fo:table margin-top="10pt" border="solid 0.4mm black">
                        <fo:table-header>
                            <fo:table-row>
                                <fo:table-cell border="solid 0.1mm black" padding-top="1mm" text-align="center">
                                    <fo:block font-weight="bold">
                                        Red.
                                        broj
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding-top="1mm" text-align="center">
                                    <fo:block font-weight="bold">
                                        Tražilac informacije
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding-top="1mm" text-align="center">
                                    <fo:block font-weight="bold">
                                        Broj podnetih žalbi
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding-top="1mm" text-align="center">
                                    <fo:block font-weight="bold">
                                        Broj žalbi zbog cutanja
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black"  padding-top="1mm" text-align="center">
                                    <fo:block font-weight="bold">
                                        Broj žalbi na odluku
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="/izvestaj/trazilac-informacije">
                                <fo:table-row>
                                    <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                        <fo:block>
                                            <xsl:value-of select="position()"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                        <fo:block>
                                            <xsl:value-of select="naziv"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                        <fo:block>
                                            <xsl:variable name="zalbeCutanje" select="zalbe/@cutanje"/>
                                            <xsl:variable name="zalbeNaOdluku" select="zalbe/@na-odluku"/>
                                            <xsl:value-of select="$zalbeCutanje + $zalbeNaOdluku"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                        <fo:block>
                                            <xsl:value-of select="zalbe/@cutanje"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                        <fo:block>
                                            <xsl:value-of select="zalbe/@na-odluku"/>
                                        </fo:block>
                                    </fo:table-cell>

                                </fo:table-row>
                            </xsl:for-each>
                            <fo:table-row>
                                <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                    <fo:block font-weight="bold">
                                        Ukupno
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                    <fo:block font-weight="bold">
                                        <xsl:variable name="zalbeCutanje"
                                                      select="/izvestaj/godisnja-statistika/@zalbe-cutanje"/>
                                        <xsl:variable name="zalbeNaOdluku"
                                                      select="/izvestaj/godisnja-statistika/@zalbe-na-odluku"/>
                                        <xsl:value-of select="$zalbeCutanje + $zalbeNaOdluku"/>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                    <fo:block font-weight="bold">
                                        <xsl:value-of select="/izvestaj/godisnja-statistika/@zalbe-cutanje"/>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid 0.1mm black" padding="1.2mm">
                                    <fo:block font-weight="bold">
                                        <xsl:value-of select="/izvestaj/godisnja-statistika/@zalbe-na-odluku"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                    <fo:block font-family="Arial" margin-top="50pt" text-align="left" border="none" font-weight="bold">
                        Rešavanje zahteva i podnete žalbe
                    </fo:block>
                    <fo:block font-family="Arial" margin-top="10pt" text-align="justify">
                        U <xsl:value-of select="/izvestaj/godisnja-statistika/@godina"/>.
                        godini podneto je ukupno
                        <xsl:value-of select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi + /izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                        zahteva za slobodan pristup informacijama od javnog značaja.
                    </fo:block>
                    <fo:block font-family="Arial" margin-top="10pt" text-align="justify">
                        Od ukupnog broja zahteva,
                        <xsl:for-each select="/izvestaj/trazilac-informacije">
                            <fo:inline>
                                <xsl:if test="count(/izvestaj/trazilac-informacije) = position()">a </xsl:if>
                            </fo:inline>
                            <xsl:value-of select="zahtevi/@prihvaceni + zahtevi/@odbijeni"/> je podneo tražilac
                            <xsl:value-of select="naziv"/>
                            <fo:inline>
                                <xsl:choose>
                                    <xsl:when test="count(/izvestaj/trazilac-informacije) = position()">. </xsl:when>
                                    <xsl:otherwise>, </xsl:otherwise>
                                </xsl:choose>
                            </fo:inline>
                        </xsl:for-each>
                    </fo:block>
                    <fo:block font-family="Arial" margin-top="10pt" text-align="justify">
                        Oko
                        <xsl:for-each select="/izvestaj/trazilac-informacije">
                            <fo:inline>
                                <xsl:if test="count(/izvestaj/trazilac-informacije) = position()">a </xsl:if>
                            </fo:inline>
                            <xsl:variable name="totalPrihvaceni" select="zahtevi/@prihvaceni + zahtevi/@odbijeni"/>
                            <xsl:value-of select="round(zahtevi/@prihvaceni div $totalPrihvaceni * 10000) div 100"/>% zahteva tražioca
                            <xsl:value-of select="naziv"/>
                            <fo:inline>
                                <xsl:choose>
                                    <xsl:when test="count(/izvestaj/trazilac-informacije) = position()"> je usvojeno. </xsl:when>
                                    <xsl:otherwise>, </xsl:otherwise>
                                </xsl:choose>
                            </fo:inline>
                        </xsl:for-each>
                    </fo:block>
                    <fo:block font-family="Arial" margin-top="10pt" text-align="justify">
                        <xsl:variable name="totalZahtevi" select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi + /izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                        Ukupan broj usvojenih zahteva je <xsl:value-of select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi"/>
                        (<xsl:value-of select="round(/izvestaj/godisnja-statistika/@prihvaceni-zahtevi div $totalZahtevi * 10000) div 100"/>%),
                        dok je odbijenih <xsl:value-of select="/izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                        (<xsl:value-of select="round(/izvestaj/godisnja-statistika/@odbijeni-zahtevi div $totalZahtevi * 10000) div 100"/>%).
                    </fo:block>
                    <xsl:if test="(/izvestaj/godisnja-statistika/@zalbe-cutanje + /izvestaj/godisnja-statistika/@zalbe-na-odluku) > 0">
                        <fo:block font-family="Arial" margin-top="10pt" text-align="justify">
                            <xsl:variable name="totalZalbe"
                                          select="/izvestaj/godisnja-statistika/@zalbe-cutanje + /izvestaj/godisnja-statistika/@zalbe-na-odluku"/>
                            <xsl:variable name="totalZahtevi"
                                          select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi + /izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                            U ovoj godini izjavljeno je
                            <xsl:value-of select="$totalZalbe"/> žalbi što predstavlja
                            <xsl:value-of select="round($totalZalbe div $totalZahtevi * 10000) div 100"/>% u odnosu na
                            ukupan broj podnetih zahteva.
                            Od ovog broja,
                            <xsl:if test="/izvestaj/godisnja-statistika/@zalbe-na-odluku > 0">
                                <xsl:value-of select="/izvestaj/godisnja-statistika/@zalbe-na-odluku"/>
                                žalbi (<xsl:value-of select="round(/izvestaj/godisnja-statistika/@zalbe-na-odluku div $totalZalbe * 10000) div 100"/>%)
                                je izjavljeno protiv obaveštenja o odbijanju zahteva
                            </xsl:if>
                            <xsl:choose>
                                <xsl:when test="/izvestaj/godisnja-statistika/@zalbe-cutanje > 0">
                                    , a <xsl:value-of select="/izvestaj/godisnja-statistika/@zalbe-cutanje"/>
                                    žalbe (<xsl:value-of select="round(/izvestaj/godisnja-statistika/@zalbe-cutanje div $totalZalbe * 10000) div 100"/>%)
                                    je izjavljeno zbog «ćutanja administracije».
                                </xsl:when>
                                <xsl:otherwise>.</xsl:otherwise>
                            </xsl:choose>
                        </fo:block>
                    </xsl:if>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>