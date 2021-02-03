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
                    table {
                    border-collapse: collapse;
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
                    min-height: 240mm;"
                >
                    <div font-family="Arial" width="60%"
                              margin-top="10pt" text-align="center" border="none">
                        <p>
                            Primena Zakona o slobodnom pristupu informacijama od javnog značaja u
                            <xsl:value-of select="/izvestaj/godisnja-statistika/@godina"/>.god.
                        </p>
                    </div>
                    <div font-family="Arial" width="60%"
                              margin-top="10pt" text-align="left" border="none">
                        <p>1. Zahtevi:</p>
                    </div>
                    <table style="margin-top:10pt;border:solid 0.4mm black;">
                        <tr>
                            <th style="border:solid 0.1mm black;padding-top:1mm;text-align:center">
                                <div style="font-weight:bold;">
                                    Red.
                                    broj
                                </div>
                            </th>
                            <th style="border:solid 0.1mm black;padding-top:1mm;text-align:center">
                                <div style="font-weight:bold;">
                                    Tražilac informacije
                                </div>
                            </th>
                            <th style="border:solid 0.1mm black;padding-top:1mm;text-align:center">
                                <div style="font-weight:bold;">
                                    Broj podnetih zahteva
                                </div>
                            </th>
                            <th style="border:solid 0.1mm black;padding-top:1mm;text-align:center">
                                <div style="font-weight:bold;">
                                    Broj prihvacenih zahteva
                                </div>
                            </th>
                            <th style="border:solid 0.1mm black;padding-top:1mm;text-align:center">
                                <div style="font-weight:bold;">
                                    Broj odbijenih zahteva
                                </div>
                            </th>
                        </tr>
                        <xsl:for-each select="/izvestaj/trazilac-informacije">
                            <tr>
                                <td style="border:solid 0.1mm black;padding:1.2mm;">
                                    <div>
                                        <xsl:value-of select="position()"/>
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding:1.2mm;">
                                    <div>
                                        <xsl:value-of select="naziv"/>
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding:1.2mm;">
                                    <div>
                                        <xsl:variable name="prihvaceniZahtevi" select="zahtevi/@prihvaceni"/>
                                        <xsl:variable name="odbijeniZahtevi" select="zahtevi/@odbijeni"/>
                                        <xsl:value-of select="$prihvaceniZahtevi + $odbijeniZahtevi"/>
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding:1.2mm;">
                                    <div>
                                        <xsl:value-of select="zahtevi/@prihvaceni"/>
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding:1.2mm;">
                                    <div>
                                        <xsl:value-of select="zahtevi/@odbijeni"/>
                                    </div>
                                </td>
                            </tr>
                        </xsl:for-each>
                        <tr>
                            <td style="border:solid 0.1mm black;padding:1.2mm;">
                            </td>
                            <td style="border:solid 0.1mm black;padding:1.2mm;">
                                <div style="font-weight:bold;">
                                    Ukupno
                                </div>
                            </td>
                            <td style="border:solid 0.1mm black;padding:1.2mm;">
                                <div style="font-weight:bold;">
                                    <xsl:variable name="prihvaceniZahtevi"
                                                  select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi"/>
                                    <xsl:variable name="odbijeniZahtevi"
                                                  select="/izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                                    <xsl:value-of select="$prihvaceniZahtevi + $odbijeniZahtevi"/>
                                </div>
                            </td>
                            <td style="border:solid 0.1mm black;padding:1.2mm;">
                                <div style="font-weight:bold;">
                                    <xsl:value-of select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi"/>
                                </div>
                            </td>
                            <td style="border:solid 0.1mm black;padding:1.2mm;">
                                <div style="font-weight:bold;">
                                    <xsl:value-of select="/izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <div font-family="Arial" width="60%"
                              margin-top="25pt" text-align="left" border="none">
                        <p>2. Žalbe:</p>
                    </div>
                    <table style="margin-top:10pt;border:solid 0.4mm black;">
                            <tr>
                                <td style="border:solid 0.1mm black;padding-top:1mm;text-align:center">
                                    <div style="font-weight:bold;">
                                        Red.
                                        broj
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding-top:1mm;text-align:center">
                                    <div style="font-weight:bold;">
                                        Tražilac informacije
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding-top:1mm;text-align:center">
                                    <div style="font-weight:bold;">
                                        Broj podnetih žalbi
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding-top:1mm;text-align:center">
                                    <div style="font-weight:bold;">
                                        Broj žalbi zbog cutanja
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding-top:1mm;text-align:center">
                                    <div style="font-weight:bold;">
                                        Broj žalbi na odluku
                                    </div>
                                </td>
                            </tr>
                        <table-body>
                            <xsl:for-each select="/izvestaj/trazilac-informacije">
                                <tr>
                                    <td style="border:solid 0.1mm black;padding:1.2mm;">
                                        <div>
                                            <xsl:value-of select="position()"/>
                                        </div>
                                    </td>
                                    <td style="border:solid 0.1mm black;padding:1.2mm;">
                                        <div>
                                            <xsl:value-of select="naziv"/>
                                        </div>
                                    </td>
                                    <td style="border:solid 0.1mm black;padding:1.2mm;">
                                        <div>
                                            <xsl:variable name="zalbeCutanje" select="zalbe/@cutanje"/>
                                            <xsl:variable name="zalbeNaOdluku" select="zalbe/@na-odluku"/>
                                            <xsl:value-of select="$zalbeCutanje + $zalbeNaOdluku"/>
                                        </div>
                                    </td>
                                    <td style="border:solid 0.1mm black;padding:1.2mm;">
                                        <div>
                                            <xsl:value-of select="zalbe/@cutanje"/>
                                        </div>
                                    </td>
                                    <td style="border:solid 0.1mm black;padding:1.2mm;">
                                        <div>
                                            <xsl:value-of select="zalbe/@na-odluku"/>
                                        </div>
                                    </td>

                                </tr>
                            </xsl:for-each>
                            <tr>
                                <td style="border:solid 0.1mm black;padding:1.2mm;">
                                </td>
                                <td style="border:solid 0.1mm black;padding:1.2mm;">
                                    <div style="font-weight:bold;">
                                        Ukupno
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding:1.2mm;">
                                    <div style="font-weight:bold;">
                                        <xsl:variable name="zalbeCutanje"
                                                      select="/izvestaj/godisnja-statistika/@zalbe-cutanje"/>
                                        <xsl:variable name="zalbeNaOdluku"
                                                      select="/izvestaj/godisnja-statistika/@zalbe-na-odluku"/>
                                        <xsl:value-of select="$zalbeCutanje + $zalbeNaOdluku"/>
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding:1.2mm;">
                                    <div style="font-weight:bold;">
                                        <xsl:value-of select="/izvestaj/godisnja-statistika/@zalbe-cutanje"/>
                                    </div>
                                </td>
                                <td style="border:solid 0.1mm black;padding:1.2mm;">
                                    <div style="font-weight:bold;">
                                        <xsl:value-of select="/izvestaj/godisnja-statistika/@zalbe-na-odluku"/>
                                    </div>
                                </td>
                            </tr>
                        </table-body>
                    </table>
                    <div style="font-family:Arial;margin-top:50pt;text-align:left;border:none;font-weight:bold">
                        <p>Rešavanje zahteva i podnete žalbe</p>
                    </div>
                    <div style="font-family:Arial;margin-top:10pt;text-align:justify;">
                        <p>U <xsl:value-of select="/izvestaj/godisnja-statistika/@godina"/>.
                            godini podneto je ukupno
                            <xsl:value-of
                                    select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi + /izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                            zahteva za slobodan pristup informacijama od javnog značaja.
                        </p>
                    </div>
                    <div style="font-family:Arial;margin-top:10pt;text-align:justify;">
                        <p>
                            Od ukupnog broja zahteva,
                            <xsl:for-each select="/izvestaj/trazilac-informacije">
                                <span>
                                    <xsl:if test="count(/izvestaj/trazilac-informacije) = position()">a </xsl:if>
                                </span>
                                <xsl:value-of select="zahtevi/@prihvaceni + zahtevi/@odbijeni"/> je podneo tražilac
                                <xsl:value-of select="naziv"/>
                                <span>
                                    <xsl:choose>
                                        <xsl:when test="count(/izvestaj/trazilac-informacije) = position()">. </xsl:when>
                                        <xsl:otherwise>, </xsl:otherwise>
                                    </xsl:choose>
                                </span>
                            </xsl:for-each>
                        </p>
                    </div>
                    <div style="font-family:Arial;margin-top:10pt;text-align:justify;">
                        <p>
                            Oko
                            <xsl:for-each select="/izvestaj/trazilac-informacije">
                                <span>
                                    <xsl:if test="count(/izvestaj/trazilac-informacije) = position()">a </xsl:if>
                                </span>
                                <xsl:variable name="totalPrihvaceni" select="zahtevi/@prihvaceni + zahtevi/@odbijeni"/>
                                <xsl:value-of select="round(zahtevi/@prihvaceni div $totalPrihvaceni * 10000) div 100"/>%
                                zahteva tražioca
                                <xsl:value-of select="naziv"/>
                                <span>
                                    <xsl:choose>
                                        <xsl:when test="count(/izvestaj/trazilac-informacije) = position()"> je usvojeno. </xsl:when>
                                        <xsl:otherwise>, </xsl:otherwise>
                                    </xsl:choose>
                                </span>
                            </xsl:for-each>
                        </p>
                    </div>
                    <div style="font-family:Arial;margin-top:10pt;text-align:justify;">
                        <p>
                            <xsl:variable name="totalZahtevi"
                                          select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi + /izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                            Ukupan broj usvojenih zahteva je
                            <xsl:value-of select="/izvestaj/godisnja-statistika/@prihvaceni-zahtevi"/>
                            (<xsl:value-of
                                select="round(/izvestaj/godisnja-statistika/@prihvaceni-zahtevi div $totalZahtevi * 10000) div 100"/>%),
                            dok je odbijenih
                            <xsl:value-of select="/izvestaj/godisnja-statistika/@odbijeni-zahtevi"/>
                            (<xsl:value-of
                                select="round(/izvestaj/godisnja-statistika/@odbijeni-zahtevi div $totalZahtevi * 10000) div 100"/>%).
                        </p>
                    </div>
                    <xsl:if test="(/izvestaj/godisnja-statistika/@zalbe-cutanje + /izvestaj/godisnja-statistika/@zalbe-na-odluku) > 0">
                        <div style="font-family:Arial;margin-top:10pt;text-align:justify;">
                            <p>
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
                                        , a
                                        <xsl:value-of select="/izvestaj/godisnja-statistika/@zalbe-cutanje"/>
                                        žalbe (<xsl:value-of select="round(/izvestaj/godisnja-statistika/@zalbe-cutanje div $totalZalbe * 10000) div 100"/>%)
                                        je izjavljeno zbog «ćutanja administracije».
                                    </xsl:when>
                                    <xsl:otherwise>.</xsl:otherwise>
                                </xsl:choose>
                            </p>
                        </div>
                    </xsl:if>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>