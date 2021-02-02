<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format"
        xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="resenje-page">
                    <fo:region-body margin-top="0.75in"
                                    margin-bottom="0.75in" margin-left="80pt" margin-right="80pt" />
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="resenje-page">
                <fo:flow flow-name="xsl-region-body">

                    <fo:block font-family="Times New Roman" width="60%"
                              margin-top="10pt" text-align="left" border="none">
                        <xsl:choose>
                            <xsl:when test="/resenje/@tip = 'prihvatanje'">
                                Решење када је жалба основана – налаже се:
                            </xsl:when>
                            <xsl:when test="/resenje/@tip = 'odbijanje-zalbe'">
                                Решење – одбија се као неоснована:
                            </xsl:when>
                            <xsl:when test="/resenje/@tip = 'odbijanje-zahteva'">
                                Решење – одбија се захтев:
                            </xsl:when>
                        </xsl:choose>
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                              text-align-last="justify" border="none">
                        Број:
                        <fo:inline  font-family="Times New Roman" font-size="10pt"
                                    font-weight="bold" text-align="center">
                            <xsl:value-of select="/resenje/broj"/>
                        </fo:inline>
                        <fo:leader leader-pattern="space" />
                        <fo:inline font-family="Times New Roman" width="60%" text-align="right" border="none">
                            Датум:
                            <fo:inline  font-family="Times New Roman" font-size="10pt"
                                        font-weight="bold" text-align="center">
                                <xsl:value-of select="/resenje/datum"/>
                            </fo:inline>
                            године.
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                              margin-top="10pt" text-align="justify" border="none">
                        Повереник за информације од јавног значаја и заштиту података о личности, у поступку по алби
                        коју је изјавио <xsl:value-of select="/resenje/zalilac/ime-prezime"/>
                        против <xsl:value-of select="/resenje/protiv/naziv"/> због
                        <xsl:choose>
                            <xsl:when test="/resenje/zalba/@tip = 'cutanje'">
                                непоступања по његовом захтеву за приступ информацијама од јавног значаја
                            </xsl:when>
                            <xsl:otherwise>
                                недобијања тражених информација по његовом захтеву за приступ информацијама од јавног значаја
                            </xsl:otherwise>
                        </xsl:choose>
                        <xsl:value-of select="/resenje/zahtev/datum"/> године, на основу
                        <xsl:for-each select="/resenje/osnov">
                            <xsl:for-each select="zakon/clan">
                                <xsl:variable name="brojClana" select="@broj"/>
                                члана <xsl:value-of select="$brojClana"/>.
                                <xsl:for-each select="stav">
                                    <xsl:variable name="brojStava" select="@broj"/>
                                    ст. <xsl:value-of select="$brojStava"/>.
                                    <xsl:for-each select="tacka">
                                        <xsl:variable name="brojTacke" select="@broj"/>
                                        тачка <xsl:value-of select="$brojTacke"/>.
                                    </xsl:for-each>
                                </xsl:for-each>
                                <xsl:value-of select="//zakon/naziv"/>
                                („Службени гласник РС“, бр.
                                <xsl:for-each select="//zakon/sluzbeni-glasnik/broj">
                                    <xsl:value-of select="."/>
                                </xsl:for-each>)
                            </xsl:for-each>,
                        </xsl:for-each>
                        доноси
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%" font-size="15pt" margin-top="10pt" margin-bottom="10pt" text-align="center" border="none">
                        Р Е Ш Е Њ Е
                    </fo:block>
                    <xsl:choose>
                        <xsl:when test="/resenje/@tip = 'prihvatanje'">
                            <fo:block font-family="Times New Roman" width="60%"
                                      margin-top="10pt" text-align="justify" border="none">
                                I Налаже се за <xsl:value-of select="/resenje/protiv/naziv"/>, да
                                без одлагања, а најкасније у року од пет дана од дана пријема овог решења, обавести <xsl:value-of select="/resenje/zalilac/ime-prezime"/>,
                                да ли поседује тражене информације односно документ у коме су исте садржане, и то:
                                <xsl:value-of select="/resenje/telo/nalog/akcija"/>
                            </fo:block>
                            <fo:block font-family="Times New Roman" width="60%"
                                      margin-top="10pt" text-align="justify" border="none">
                                II О извршењу решења <xsl:value-of select="/resenje/protiv/naziv"/>
                                ће обавестити Повереника у року од
                                <xsl:value-of select="resenje/telo/nalog/obavestiti/@rok"/>
                                дана од пријема овог решења.
                            </fo:block>
                        </xsl:when>
                        <xsl:when test="/resenje/@tip = 'odbijanje-zalbe'">
                            <fo:block font-family="Times New Roman" width="60%"
                                      margin-top="10pt" text-align="justify" border="none">
                                Одбија се, као неоснована, жалба <xsl:value-of select="/resenje/zalilac/ime-prezime"/>, изјављена 
                                <xsl:choose>
                                    <xsl:when test="/resenje/zalba/obavestenje">
                                        против обавештења број
                                        <xsl:value-of select="/resenje/zalba/obavestenje/broj-obavestenja"/>
                                        од <xsl:value-of select="/resenje/zalba/obavestenje/datum-obavestenja"/> године
                                    </xsl:when>
                                    <xsl:otherwise>
                                        у вези непоступања
                                    </xsl:otherwise>
                                </xsl:choose>, због недобијања тражених информација по његовом захтеву за приступ
                                информацијама од јавног значаја поднетом <xsl:value-of select="/resenje/zahtev/datum"/>.
                            </fo:block>
                        </xsl:when>
                        <xsl:when test="/resenje/@tip = 'odbijanje-zahteva'">
                            <fo:block font-family="Times New Roman" width="60%"
                                      margin-top="10pt" text-align="justify" border="none">
                                Одбија се, као неоснован, захтев <xsl:value-of select="/resenje/zalilac/ime-prezime"/>, за приступ информацијама од јавног значаја, поднет
                                <xsl:value-of select="/resenje/zahtev/datum"/> године <xsl:value-of select="/resenje/protiv/naziv"/>.
                            </fo:block>
                        </xsl:when>
                    </xsl:choose>

                    <fo:block font-family="Times New Roman" width="60%" font-size="12pt" margin-top="10pt" margin-bottom="10pt" text-align="center" border="none">
                        O б р а з л о ж е њ е
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                              margin-top="10pt" text-align="justify" border="none">
                        <xsl:value-of select="/resenje/zalilac/ime-prezime"/>, као тражилац информација, изјавио је дана
                        <xsl:value-of select="/resenje/zalba/datum"/> жалбу Поверенику, због
                        непоступања <xsl:value-of select="/resenje/protiv/naziv"/> по
                        његовом захтеву од <xsl:value-of select="/resenje/zahtev/datum"/> за приступ информацијама од јавног значаја и у прилогу
                        доставио копију истог.
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                              margin-top="10pt" text-align="justify" border="none">
                        Поступајући по жалби, Повереник је дана <xsl:value-of select="/resenje/zalba/datum"/> упутио исту на изјашњење
                        <xsl:value-of select="/resenje/protiv/naziv"/>, као органу власти у
                        смислу члана 3. Закона о слободном приступу информацијама од јавног значаја и затражио да се
                        изјасни о наводима жалбе, посебно о разлозима непоступања у законском року по поднетом захтеву
                        у складу са одредбама члана 16. ст.1-9. или ст. 10. Закона, остављајући рок од осам дана, поводом
                        чега
                        <xsl:choose>
                            <xsl:when test="/resenje/obrazlozenje/izjasnjenje/@odgovor = 'true'">
                                је
                            </xsl:when>
                            <xsl:otherwise>
                                није
                            </xsl:otherwise>
                        </xsl:choose>
                        добио одговор.
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                              margin-top="10pt" text-align="justify" border="none">
                        По разматрању жалбе и осталих списа овог предмета, донета је одлука као у диспозитиву
                        решења из следећих разлога:
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                              margin-top="10pt" text-align="justify" border="none">
                        Увидом у списе предмета утврђено је да је <xsl:value-of select="/resenje/zalilac/ime-prezime"/>,
                        дана <xsl:value-of select="/resenje/zahtev/datum"/>, поднео <xsl:value-of select="/resenje/protiv/naziv"/>,
                        захтев за приступ информацијама од јавног значаја којим је тражио информације од јавног значаја, ближе
                        наведенe у ставу I диспозитива овог решења.
                    </fo:block>
                    <xsl:if test="/resenje/zalba/@tip = 'cutanje'">
                        <fo:block font-family="Times New Roman" width="60%"
                                  margin-top="10pt" text-align="justify" border="none">
                            Такође је увидом у списе предмета утврђено да по захтеву жалиоца од <xsl:value-of select="/resenje/zahtev/datum"/>,
                            орган власти није поступио, што је био дужан да учини без одлагања, а најкасније у року од 15 дана
                            од пријема захтева те да жалиоца, у смислу члана 16. став 1. Закона о слободном приступу
                            информацијама од јавног значаја, обавести да ли поседује тражене информације и да му, уколико
                            исте поседује, стави на увид документ који исте садржи односно изда му или достави копију
                            документа у коме су тражене информације садржане, или да у супротном донесе решење о одбијању
                            захтева, у смислу става 10. истог члана.
                        </fo:block>
                    </xsl:if>
                    <fo:block font-family="Times New Roman" width="60%"
                              margin-top="10pt" text-align="justify" border="none">
                        <xsl:value-of select="/resenje/protiv/naziv"/>, је дужан да о
                        извршењу решења из става I диспозитива, обавести Повереника у складу са чланом 24. став 3. Закона
                        о слободном приступу информацијама од јавног значаја.
                    </fo:block>
                    <xsl:if test="/resenje/@tip = 'prihvatanje'">
                        <fo:block font-family="Times New Roman" width="60%"
                                  margin-top="10pt" text-align="justify" border="none">
                            Упутство о правном средству:
                        </fo:block>
                        <fo:block font-family="Times New Roman" width="60%"
                                  margin-top="10pt" text-align="justify" border="none">
                            Против овог решења није допуштена жалба већ се, у складу са Законом о управним
                            споровима, може покренути управни спор тужбом
                            <xsl:value-of select="/resenje/obrazlozenje/pravno-sredstvo/sud/naziv"/>, у року од
                            <xsl:value-of select="/resenje/obrazlozenje/pravno-sredstvo/@rok"/>
                            дана од дана пријема решења. Такса на тужбу износи
                            <xsl:value-of select="/resenje/obrazlozenje/pravno-sredstvo/@taksa"/> динара.
                        </fo:block>
                    </xsl:if>
                </fo:flow>
            </fo:page-sequence>

        </fo:root>
    </xsl:template>
</xsl:stylesheet>