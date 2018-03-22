package com.example.kai.appalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MessengerFrageAusgabe extends AppCompatActivity
{

    private TextView titel;
    private TextView antwort;
    String frage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_messenger_ausgabe);
        Intent i = getIntent();
        Bundle b = i.getExtras();

        antwort = findViewById(R.id.textView27);
        antwort.setMovementMethod(new ScrollingMovementMethod());
        antwort.measure(0, 0);
        if (b != null)
        {
            frage = (String) b.get("frage");

        }
        titel = findViewById(R.id.textView28);
        titel.setText(frage);
        assert frage != null;
        switch (frage)
        {
            case "Wie vertragen sich Allergie-Immuntherapie und Betablocker?":
                antwort.setText("Die Wirkstoffgruppe der Beta-Rezeptorenblocker ist bei allen Präparaten zur subkutanen Allergie-Immuntherapie (SCIT) kontraindiziert. Auch in der aktuellen Leitlinie der allergologischen Fachgesellschaften zur (allergen-)spezifischen Immuntherapie wird sowohl die systemische als auch lokale Verabreichung von Betablockern ausdrücklich als Kontraindikation zur SCIT genannt, da möglicherweise das Risiko für eine bronchiale Obstruktion erhöht sowie eine im Notfall erforderliche Adrenalingabe weniger effektiv sein könnte (Pfaar 2014).\n In einem Übersichtsartikel aus dem Jahre 2008 geht der Autor David M. Lang der Frage nach, ob Betablocker das Risiko einer Anaphylaxie unter Immuntherapie erhöhen. Zusammenfassend wurde festgestellt, dass Anaphylaxien bei Patienten unter Betablocker- und Immuntherapie nicht häufiger in der Zahl auftraten, jedoch ein höheres Risiko eines schweren Verlaufs bestand.\n Die Nutzen-Risiko-Abwägung im Einzelfall hängt auch von der Indikation sowohl der Allergie-Immuntherapie als auch des Betablockers ab und ist vom behandelnden Arzt zu treffen. So sind Betablocker bei koronarer Herzkrankheit, Herzinsuffizienz oder Arrhythmie schwer zu ersetzen, das Absetzen kann sogar fatale Folgen haben. Liegt gleichzeitig mit einer Insektengiftallergie eine vitale Indikation für die Allergie-Immuntherapie vor, kann die Entscheidung auch zugunsten der Immuntherapie ausfallen (Müller 2005). Hierbei wäre zu berücksichtigen, dass die Behandlung trotz Vorliegen einer Kontraindikation einen Off-Label-Use darstellt. Bei einem solchen Off-Label-Use werden besondere Anforderungen an die Aufklärung des Patienten gestellt, und die haftungsrechtliche Verantwortung liegt beim Arzt.\n Für die sublinguale Immuntherapie (SLIT) gelten in Bezug auf die Betablocker Präparate-spezifische Unterschiede (Pfaar 2014). Früher wurden Betablocker als Kontraindikation auch der SLIT angesehen. Sowohl in Studien als auch aufgrund der Beobachtungen in der breiten Anwendung zeigte sich in Bezug auf systemische Neben­wirkungen jedoch ein sehr günstiges Sicherheitsprofil der SLIT. Daher werden Betablocker in den Leitlinien der allergologischen Fachverbände seit 2006 nicht mehr als Kontraindikation der SLIT aufgeführt. Für die Beurteilung eines eventuellen Off-Label-Einsatzes eines Präparates ist letztlich immer die spezifische Fachinformation des entsprechenden Präparates ausschlaggebend. Die sublingualen Präparate von ALK sind bei Betablockern ausnahmslos nicht kontraindiziert.\n\n\n Referenzen \n\n\nPfaar O. et al., Leitlinie der DGAKI, Allergo J Int 2014, 23: 282-319 \nMüller U.R. et al., J Allergy Clin Immunol 2005, 115 (3): 606-10\n Lang D.M., Curr Allergy Asthma Rep 2008, 8(1): 37-44");
                break;
            case "Welche allergologische Relevanz hat Ragweed (Ambrosia)?":
                antwort.setText("Unter der Bezeichnung Ragweed werden verschiedene Arten der Gattung Ambrosia zusammengefasst, z. B. Ambrosia artemisiifolia (Synonym: A. elatior), A. trifida, A. maritima. Die häufigste Art in Europa ist Ambrosia artemisiifolia (Beifußblättriges Traubenkraut, englisch: Short Ragweed) (D\'Amato 1998 und 2007). Wird hierzulande von Ragweed gesprochen, ist in aller Regel diese Art gemeint. Botanisch gehört Ragweed zu den Korbblütengewächsen und ist nahe verwandt mit Beifuß. Tatsächlich treten eine Beifuß- und eine Ragweed-Sensibilisierung häufig gemeinsam auf, was eine Kreuzallergenität beider Pflanzen nahelegt (Treudler 1995, Hirschwehr 1998). Die Kreuzallergenität zwischen spezifischen Allergenen der beiden Pflanzen scheint jedoch nur gering ausgeprägt zu sein (z.B. Amb a 1/Amb a 2 mit Art v 6). Eine starke Kreuzreaktion findet sich vor allem bei den Panallergenen, Profilin und Kalzium-bindenden Proteinen (Wopfner 2005, Asero 2006).\n" +
                        "In Nordamerika ist Ragweed (Ambrosia) einer der bedeutendsten Auslöser der allergischen Rhinokonjunktivitis und kann schwerste Asthma-Attacken verursachen. Von dort wurde es nach dem ersten Weltkrieg nach Europa eingeschleppt und hat sich vor allem im südöstlichen Europa, Frankreich und Italien ausgebreitet. Das Verbreitungs­gebiet der Pflanze in Europa dehnt sich inzwischen stetig weiter aus, insbesondere entlang von Hauptverkehrswegen (Autobahnen, Bahnhöfe). Zudem trägt die Verunreinigung von Vogelfutter mit Ragweed-Saat zur Streuung der Pflanze bei (Rybnicek 2001).\n" +

                        "  Untersuchungen zufolge wird die Anzahl der Patienten, die auf Ragweed allergisch sind, in den Jahren 2041 bis 2060 weltweit von jetzt 33 Millionen auf 77 Millionen ansteigen (Lake 2017). Aufgrund des Klimawandels werden auch Gebiete betroffen sein, in denen Ragweed derzeit noch nicht so stark verbreitet ist; das würde dann auch Deutschland betreffen (Schmidt 2017). Rasmussen et al (2017) sprechen von neuen high allergy risk-Gebieten in Nord- und Osteuropa, in denen sich die klimatischen Bedingungen günstig für die Ausbreitung von Ragweed entwickeln könnten.\n" +

                        "Professor Bergmann bezeichnet Ambrosia als Paradebeispiel für besonders aggressive Pollen. Sensibilisierungen auf Ragweed (Ambrosia)-Allergene findet man bei 15 % der Erwachsenen, wobei vor allem die 50- bis 60-jährigen von den Symptomen betroffen sind (Bergmann 2005). Bereits zehn luftgetragene Ragweed (Ambrosia)-Pollen können Rhinitis­symptome auslösen (Fath 2014). Unter bestimmten Bedingungen setzen die Pollenkörner Subpollen-Partikel frei (SPP), die so klein sind, dass sie eingeatmet werden können, während die intakten Pollenkörner in den oberen Atem­wegen auf der Schleimhaut hängen bleiben. Auch diese SPP enthalten alle relevanten Allergene (Smiljanic 2017). Dies erklärt die Relevanz von Ragweed in Bezug auf das Auftreten von Asthma.\n" +

                        "Das Vorliegen Ragweed (Ambrosia)-spezifischer IgE-Antikörper im Serum kann sowohl eine direkte Sensibilisierung gegen Ragweed (Ambrosia)-Pollen als auch eine Kreuzreaktion, z.B. bei Sensibilisierung gegenüber anderen Korbblütlern oder bestimmten Nahrungsmittel­allergenen, anzeigen, die z.B. durch Panallergene wie Profiline verursacht werden (Boehme 2009, Asero 2011).\n" +

                        " Besteht der Verdacht auf eine klinisch relevante Allergie, stehen von ALK sowohl eine Pricktestlösung als auch Therapielösungen der Präparate Pangramin ULTRA® (ab 12/2017) für die subkutane Therapie oder SLIToneULTRA® für die sublinguale Therapie zur Verfügung. Die Wirksamkeit dieser sublingualen Allergie-Immuntherapie von ALK  wurde in einer offenen, kontrollierten klinischen Studie nachgewiesen (Valle 2000).\n" +

                        " In den USA ist RAGWITEK® für die Tabletten-Immuntherapie bei Ragweed (Ambrosia)-Allergie von der FDA zugelassen und seit April 2014 dort verfügbar. Als Basis für die Zulassung dienten Studien zur Sicherheit und Wirksamkeit (Nolte 2013 und 2014, Creticos 2013). Das Verfahren zur Zulassung von RAGWITEK® in Deutschland sollte im Laufe des Jahres 2018 abgeschlossen sein, so dass das Präparat  als sublinguale Allergie-Immuntherapie in Tablettenform dann auch hier zu Verfügung stehen wird.\n\n" +

                        " Referenzen\n\n" +
                        "G. D'Amato et al., Allergy 1998, 53: 567-78\n" +
                        "G. D'Amato et al., Allergy 2007, 62: 976-990\n" +
                        "R. Treudler et al., Allergo J 1995, 4(5): 267-271\n" +
                        "R. Hirschwehr et al., J Allergy Clin Immunol 1998, 101 (2Pt1): 196-206\n" +
                        "N. Wopfner et al., Int Arch Allegy Immunol 2005, 138: 337-46\n" +
                        "R. Asero et al., Clin Exp Allergy 2006, 36: 658-65\n" +
                        " O. Rybnicek, S. Jaeger; ACI International 2001, 13: 60-66\n" +
                        "K.C. Bergmann; Allergo J 2005, 15: 389\n" +
                        "R. Fath, springermedizin.de basierend auf: Symposium Klimawandel und Pollenflug: aktuelle Allergien und Apps, 29.3.2014, 55. Kongress der DGP und 36. Jahrestagung der GPP, Bremen\n" +
                        "M.W. Boehme et al., Dtsch Med Wochenschr. 2009, 134: 1457-63\n" +
                        "R. Asero et al. Allergy Asthma Proc 2011, 32 (1): 64-67\n" +
                        "C. Valle et al., Allergol Immunopathol (Madr) 2000, 28: 311-17\n" +
                        "H. Nolte et al., Ann Allergy Asthma Immunol 2013, 110: 450-56\n" +
                        "H. Nolte et al., Ann Allergy Asthma Immunol 2014, 113: 93-100\n" +
                        "P.S. Creticos et al., J Allergy Clin Immunol 2013, 131 (5): 1342-49\n" +
                        "I.R. Lake et al., Environ Health Perspect 2017, 125(3): 385-91\n" +
                        "C.W. Schmidt, Environ Health Perspect 2017, 1; 125(3): A60\n" +
                        "K. Rasmussen et al., Peer J 2017, PeerJ 5:e3104; DOI 10.7717/peerj.3104)\n");
                break;
            case "Wie wird ein Pricktest durchgeführt und das Ergebnis bewertet?":
                antwort.setText("Zu Beginn der Allergiediagnostik steht die detaillierte Anamnese, d.h. die gezielte Befragung des Patienten nach seinen allergisch bedingten Beschwerden und deren Begleitumständen. Im Anschluss wird üblicherweise ein Pricktest durchgeführt, um den oder die genauen Allergie\u00ADauslöser zu identifizieren. Alternativ oder zusätzlich können in vitro-Testverfahren angewendet werden, z.B. wenn das Pricktest-Ergebnis nicht eindeutig ist, ein Pricktest-Extrakt nicht zur Verfügung steht oder eine komponentenbasierte Diagnostik erforderlich ist.\n" +
                        "\n" +
                        "Der Pricktest gilt als Hauttestmethode der Wahl zur Ermittlung einer IgE-vermittelten Soforttyp-Allergie. Die Vorteile des Pricktests gegenüber anderen Hauttests liegen in der guten Reproduzierbarkeit, der hohen diagnostischen Aussagekraft sowie einem geringen Neben\u00ADwirkungsrisiko (Ruëff 2010).\n" +
                        "\n" +
                        "Durchführung: Vor einem Hauttest ist zu prüfen, ob Kontraindikationen vorliegen. Außerdem sollte die Einnahme von Medikamenten ausgeschlossen werden, die eine potentielle Hautreaktion unterdrücken können (z.B. Antihistaminika oder Kortikisteroide/Kortikoide). Die Pricktestung wird in der Regel auf der Innenseite des Unterarms des Patienten durchgeführt. Im Testareal sollten keine Hauterkrankungen vorhanden sein. Zu Beginn der Pricktestung wird die Haut im Bereich der Unterarme mit einem alkoholhaltigen Hautdesinfektionsmittel desinfiziert.\n" +
                        "\n" +
                        "Danach wird das Testareal zum Beispiel mit einem Hautmarker beschriftet. Es können 10-20 verschiedene Allergenlösungen sowie eine Positiv- (Histamin) und eine Negativ\u00ADkontrolle ohne Wirkstoff aufgetragen werden. Dabei ist darauf zu achten, dass die Areale für die einzelnen Pricktestungen nicht zu dicht beieinander liegen (Abstand mindestens 2 cm), um ein Überlagern der Testreaktionen zu vermeiden. Die Haut wird durch die Tropfen hindurch mit Hilfe einer standardisierten Pricklanzette (z.B. ALK-Lancet) oberflächlich angestochen und das Allergen auf diese Weise in die Haut eingebracht.\n" +
                        "\n" +
                        "Grundsätzlich wird empfohlen, für jedes Allergen eine neue Lanzette zu verwenden. Vielfach wird jedoch in der klinischen Routine je Patient eine Lanzette verwendet und nach jedem Prick die Lanzette mit einem Tupfer gereinigt. Dies birgt jedoch das Risiko der Allergenverschleppung, ungewöhnliche Reaktionen müssen entsprechend kritisch bewertet werden. Die Negativ- und Positivkontrolle werden generell zuletzt getestet.\n" +
                        "\n" +
                        "Auswertung: Das Ergebnis wird nach 15 Minuten abgelesen. Sollten in der Praxis widrige Umstände den empfohlenen Ablesezeitpunkt verhindern, kann auch im Zeitraum von 10 bis 40 min nach dem Pricken noch ein verlässliches Ergebnis erzielt werden. Zeiten unter 10 und über 40 min beinhalten das Risiko einer deutlich abnehmenden Qualität (Seibert 2011).\n" +
                        "\n" +
                        "Diagnostisch verwertbar sind Testergebnisse nur, wenn auf die Negativkontrolle keine (maximaler Quaddeldurchmesser beim Pricktest <2 mm) und auf die Histaminkontrolle eine eindeutige, mindestens 1+-Reaktion (Quaddeldurchmesser mindestens 3 mm) auftritt. Als positiv (+) gilt eine Testreaktion ab einem Quaddeldurchmesser ≥ 3mm. Zusätzlich ist eine semiquantitative Bewertung anhand der Quaddelgröße in mm möglich.\n" +
                        "\n" +
                        "Semiquantitative Bewertung der Pricktest-Ergebnisse gemäß Hauttest-Leitlinie (Ruëff 2010):\n" +
                        "\n" +
                        "ø                      Quaddelgröße 0 mm                                              negativ\n" +
                        "(+)                   Quaddelgröße <3 mm                                            fraglich positiv\n" +
                        "+                      Quaddelgröße ≥ 3 bis < 4 mm                              einfach positiv         \n" +
                        "+ +                 Quaddelgröße ≥ 4 bis < 5 mm                                zweifach positiv\n" +
                        "+ + +               Quaddelgröße ≥ 5 bis < 6 mm                               dreifach positiv\n" +
                        "+ + + +            Quaddelgröße ≥ 6 mm                                           vierfach positiv\n" +
                        "\n" +
                        "Die Deklaration der biologischen Aktivität der wesentlichen Pricktest-Allergene von ALK erfolgt in HEP-Einheiten. HEP bedeutet „Histamin Equivalent im Pricktest“. Ein HEP ist die allergene Potenz eines Extraktes, die im Pricktest im Durchschnitt dieselbe Quaddel\u00ADfläche hervorruft wie eine 1 mg/ml starke Histamin-Lösung. Der Allergengehalt der ALK-prick SQ-Präparate ist auf 10 HEP eingestellt, löst also bei einem durchschnittlichen Allergiker eine Quaddell aus wie eine 10 mg/ml starke Histaminlösung. Die Positiv-Kontrolle von ALK enthält entsprechend 10 mg/ml Histamindihydrochlorid (entspricht 1 % Histamin). Auf dieser Basis ist eine semiquantitative Bewertung des Testergebnisses im Vergleich zur Positivkontrolle möglich.\n" +
                        "\n" +
                        "Semiquantitative Bewertung der Pricktest-Ergebnisse gemäß Fachinformation ALK-prick-Präparate:\n" +
                        "\n" +
                        "Größer als Positiv-Kontrolle          ++++\n" +
                        "Gleich groß                                       +++\n" +
                        "Kleiner                                               ++\n" +
                        "Deutlich kleiner                                +\n" +
                        "Keine Reaktion                                 0\n" +
                        "\n" +
                        "Generell ist zu beachten, dass eine positive Testreaktion lediglich eine allergische Sensibilisierung nachweist. Die klinische Relevanz kann durch einen Pricktest nicht beurteilt werden. Dies gelingt nur im Zusammenhang mit einer ausführlichen Anamnese bzw. in Zweifelsfällen mit der nasalen/konjunktivalen Provokation.\n" +
                        "\n" +
                        "Referenzen\n" +
                        "Ruëff F et al., Allergo J 2010, 19: 402-15\n" +
                        "Seibert SM et al., Allergy Asthma Proc 2011, 32: 203-05");
                break;
            case "Für welche Präparate von ALK gilt die Indikation Asthmaprävention und gibt es einen Schutz vor Neusensibilisierungen?":
                antwort.setText("Die aktuelle „Leitlinie zur (allergen-)spezifischen Immuntherapie bei IgE-vermittelten allergischen Erkrankungen“ empfiehlt, Präparate mit nachgewiesenen präventiven Effekten, d.h. mit nachgewiesener Reduktion von Neusensibilisierungen und vermindertem Asthmarisiko, bevorzugt einzusetzen (Pfaar 2014).\n" +
                        "\n" +
                        "Die Asthmaprävention ist für unsere ALK-depot SQ® Baumpollen- und Gräser/Roggen-Präparate und der Schutz vor Neusensibilisierungen für die ALK-depot SQ® Milbenpräparate bereits im Juni 2008 vom Paul-Ehrlich-Institut zugelassen worden. Diese Indikation besteht im Bereich der Allergie-Immuntherapie (AIT) ausschließlich für die genannten Produkte von ALK.\n" +
                        "\n" +
                        "Als Basis der Indikation 'Prävention von Neusensibilisierungen' dient die Studie von Pajno (2001), in der nachgewiesen werden konnte, dass nach einem 6-jährigen Beobachtungs\u00ADzeitraum 75 % der Kinder, die auf Hausstaubmilben monosensibilisiert und mit der AIT behandelt worden waren, keine neuen Sensibilisierungen zeigten. Dagegen hatten nur 33 % der Patienten der Kontrollgruppe keine weitere Sensibilisierung entwickelt. Eine andere 6-Jahres-Studie mit 74 Patienten zeigte die präventive Langzeitwirkung der ALK-depot SQ® Milbenpräparate (Haugaard 1997). Aufgrund dieses vom Paul-Ehrlich Institut zugelassenen präventiven Effekts wird ALK-depot SQ® Hausstaubmilben von der aktuellen Leitlinie empfohlen.\n" +
                        "\n" +
                        "In der über 10 Jahre durchgeführten PAT-Studie (Preventive Allergy Treatment) wurde gezeigt, dass 7 Jahre nach Beendigung einer Allergie-Immuntherapie mit Birkenpollen und/oder Gräserpollen das Asthmarisiko der Verum- gegenüber der Kontrollgruppe signifikant reduziert war (Jacobsen 2007). Dies ist bisher die einzige Studie mit einem Präparat zur subkutanen AIT, die zur Beurteilung des Langzeiteffektes eine Nachbeobachtungsphase beinhaltet. Damit sind die ALK-depot SQ® Gräser- und Frühblüherpräparate die derzeit einzigen Arzneimittel, für die ein Nachweis von Asthma-präventiven Eigenschaften mit entsprechender Zulassung besteht.\n" +
                        "\n" +
                        "Die Ergebnisse dieser Studien zeigen, dass die Allergie-Immuntherapie mit den genannten Produkten einen positiven Einfluss auf den Verlauf der allergischen Erkrankung hat und sind als anzustrebende, sekundär-präventive Effekte der AIT in die S2-Leitlinie zur AIT in Kapitel 4.4 „Prävention von Asthma und Neusensibilisierungen“ eingeflossen (Pfaar 2014).\n" +
                        "\n" +
                        "Um den Asthma-präventiven Effekt von GRAZAX nachzuweisen, wurde von 2011 bis 2015 eine weitere Studie durchgeführt. Die „GRAZAX Asthma Präventionsstudie“ (GAP) ist die bisher größte pädiatrische Studie zur spezifischen Immuntherapie und die erste doppelblind-placebokontrollierte, randomisierte Studie, die den präventiven Effekt der Immuntherapie auf Asthma untersucht (Valovirta 2011).\n" +
                        "\n" +
                        "Diese im November 2015 abgeschlossene Studie konnte zeigen, dass sich bei Kindern die Behandlung mit GRAZAX positiv auf die Entwicklung von Asthmasymptomen und den Einsatz von Asthmamedikamenten auswirkt. Das Chancenverhältnis für das Auftreten von Asthmasymptomen1 oder den Einsatz von Asthmamedikamenten2  betrug am Ende des fünfjährigen Beobachtungszeitraums 0,66 (p < 0,05) zugunsten der GRAZAX-Behandlung.\n" +
                        "\n" +
                        "Obwohl der primäre Endpunkt der Studie verfehlt wurde, konnte die GAP-Studie (Valovirta 2017) zeigen, dass\n" +
                        "\n" +
                        "GRAZAX den Anteil der Kinder, die Asthmasymptome1 entwickelten oder Asthmamedikamente2 einnahmen, signifikant reduzierte – ein Effekt, der sowohl in den Sommer- als auch in den Wintervisiten beobachtet wurde und auch über einen Zeitraum von zwei Jahren nach Therapieende erhalten blieb;\n" +
                        "je jünger die Kinder bei Therapiebeginn waren, umso geringer war die number needed to treat (NNT*) – ein Hinweis darauf, die Therapie früh im Kindesalter zu beginnen;\n" +
                        "       * NNT = Anzahl der Patienten, die behandelt werden müssen, um ein klinisches Ereignis innerhalb eines Zeitraums zu verhindern\n" +
                        "der bereits für Erwachsene nachgewiesene krankheitsmodifizierende Effekt auch 2 Jahre nach Therapieende nun erstmals auch für Kinder mit allergischer Rhinokonjunktivitis nachgewiesen wurde.\n" +
                        "1 Die Asthmasymptome umfassten Pfeifatmung, Engegefühl in der Brust, Kurzatmigkeit oder Husten an mehr als zehn aufeinanderfolgenden Tagen. \n" +
                        "2 Die Asthmamedikamente umfassten kurzwirkenden Beta-2-Agonisten (SABA), systemisches Kortikosteroid, inhalatives Kortikosteroid (ICS), Leukotrien-Rezeptor-Antagonist (LTRA), langwirkenden Beta-2-Agonisten (LABA), Theophyllin mit verzögerter Freisetzung oder Cromoglycinsäure\n" +
                        "\n" +
                        "Referenzen\n" +
                        "Pajno G B et al., Clinical and Experimental Allergy 2001; 31: 1392-97\n" +
                        "Jacobsen L et al., Allergy. 2007; 62 (8): 943-48\n" +
                        "Pfaar O et al., Allergo J Int 2014; 23: 282-319\n" +
                        "Haugaard, L. et al., Allergy 1997; 52 (37): 162\n" +
                        "Valovirta E et al., Clin Ther 2011; 33 (10): 1537-46\n" +
                        "Valovirta E et al., Journal of Allergy and Clinical Immunology (2017), doi: 10.1016/j.jaci.2017.06.014");
                break;
            case "Was ist der Unterschied einer Allergie-Immuntherapie mit Allergoiden vs. nativen Allergenen?":
                antwort.setText("Neben nativen Allergenen werden zur Allergie-Immuntherapie (AIT) auch chemisch modifizierte Allergene, sogenannte Allergoide, eingesetzt. Durch die chemische Behandlung der nativen Allergene mit Formaldehyd oder Glutaraldehyd kommt es zur Proteinpolymerisierung, die zur Zerstörung von B-Zell-Epitopen (Bindungsstellen für B-Zellen) und damit zur Abnahme des Nebenwirkungsrisikos (Allergenität) führen soll. Im Gegensatz dazu sollen die für die Wirksamkeit der AIT bedeutenden T-Zell-Epitope und damit die Immunogenität erhalten bleiben, so dass bei unveränderter Wirksamkeit gegenüber den nativen Allergenextrakten das Nebenwirkungsrisiko vermindert werden soll. Dieses Konzept ist jedoch wissenschaftlich nicht belegt. Vielmehr gibt es deutliche Hinweise darauf, dass durch die chemische Modifikation auch die T-Zell-Epitope zerstört werden:\n" +
                        "\n" +
                        "In in vitro-Tests konnte das Allergoid-Konzept nicht bestätigt werden. Es wurden native Allergene mit Allergoiden hinsichtlich ihrer Effekte auf T-Zellstimulation (Immunogenität) und Histaminfreisetzung (Allergenität) durch Mastzellen verglichen. Die Versuche zeigen, dass native Allergene (ALK-depot SQ®) eine deutlich bessere T-Zellstimulation als auch eine höhere Histaminfreisetzung hervorrufen als die meisten Allergoide (Lund 2007).\n" +
                        "\n" +
                        "Zu vergleichbaren Ergebnissen kommt auch die Arbeitsgruppe um Professor Saloga. Die Ergebnisse dieser Forschungsarbeiten zeigen, dass die Allergenität, gleichzeitig aber auch die Immunogenität der mit Glutaraldehyd-modifizierten Allergoide im Vergleich zu nativen Allergenen signifikant verringert wird. Dies bedeutet, dass eine verringerte Allergenität zu verringerter Immunogenität führt (Heydenreich 2012).\n" +
                        "\n" +
                        "Während des 27. Mainzer Allergie-Workshops wurden ähnliche Untersuchungsergebnisse von mit Glutaraldehyd-modifizierten Birkenpollen-Allergoiden vorgestellt (Rauber 2015). Hier konnte gezeigt werden, dass nicht nur die Aufnahme der Allergoide in dendritische Zellen, sondern auch die endolysosomale Prozessierung der Allergoide in den dendritischen Zellen verzögert abläuft.\n" +
                        "\n" +
                        "Auch ältere Ergebnisse bestätigen eine bessere T-Zellstimulation durch native Allergene: schon 1997 wurde gezeigt, dass die Effekte der Allergie-Immuntherapie durch einen direkten Einfluss auf allergenspezifische T-Helferzellen (TH-Zellen) zustande kommen (Ebner 1997). Die Forscher wiesen nach, dass die AIT mit funktionell nativen ALK-Allergenen\n" +
                        "\n" +
                        "eine Allergentoleranz auf Ebene der TH-Zellen und \n" +
                        "eine Umschaltung (Switch) der Zytokin-Antwort von TH2 zu TH1 induziert.\n" +
                        "Aufgrund der zentralen Bedeutung der T-Helfer-Lymphozyten verglich die Arbeitsgruppe in einer weiteren Studie das T-Zell-Stimulationspotential eines nativen Allergens mit dem eines Formaldehyd-modifizierten Allergoids: Mit nativen Allergenen proliferierten allergenspezifische T-Zelllinien deutlich besser (Dormann 1998). Die Wissenschaftler kommen zu dem Schluss, dass diese Ergebnisse die Unterschiede in der Verfügbarkeit von T-Zell-Epitopen nativer Allergene und chemisch modifizierter Allergoide demonstrieren. Höchstwahrscheinlich sind diese auf die strukturelle Veränderung des Allergenmoleküls zurückzuführen.\n" +
                        "\n" +
                        "Wichtiger noch als die Diskussion um den theoretischen Hintergrund der Therapieform ist der Nachweis von Sicherheit und Wirksamkeit für die einzelnen Präparate. Dabei ist die Veröffentlichung des Paul-Ehrlich-Institutes (PEI) zur Risikobewertung von Test- und Therapieallergenen im Bundesgesundheitsblatt von besonderem Interesse: Die Autoren haben eine Analyse der von 1991 bis 2000 an das PEI gemeldeten Verdachtsfälle von unerwünschten Arzneimittelnebenwirkungen durchgeführt und kommen unter anderem zu folgendem Ergebnis: \"Die hypothetische Annahme bezüglich einer besseren Verträglichkeit der Allergoide gegenüber nativen Allergenpräparaten ließ sich durch unsere Ergebnisse nicht bestätigen\" (Lüderitz-Püchel 2001).\n" +
                        "\n" +
                        "Die Wirksamkeit der Allergie-Immuntherapie ist überwiegend durch doppelblind-plazebokontrollierte Studien mit intakten Allergenen belegt. Insbesondere der Langzeiteffekt, die Prävention von Asthma sowie die Verhinderung von Neusensibilisierungen sind bisher umfassend nur für die intakten Allergene von ALK nachgewiesen. Dementsprechend sind diese Präventiveffekte auch nur für ALK-depot SQ®-Präparate als Indikation vom Paul-Ehrlich-Institut zugelassen.\n" +
                        "\n" +
                        "Dass die Studienergebnisse in den klinischen Alltag übertragbar sind, zeigt eine retrospektive Kohortenstudie aus Daten der AOK Sachsen, der Daten von mehr als 1,8 Millionen Versicherten zugrunde liegen. Die statistische Analyse ergab einen signifikanten Asthma-präventiven Effekt für native Allergene, während Allergoide die Signifikanz verfehlten (Schmitt 2015).\n" +
                        "\n" +
                        "Die klinische Wirksamkeit von Allergoiden wurde in einer systematischen Übersichtsarbeit auf ihre Evidenz überprüft. In diese Studienübersicht wurden nur Allergoid-Studien mit hohem Evidenzgrad eingeschlossen, wobei die Qualität dieser Studien und auch die Wirksamkeit der Präparate anhand der World Allergy Organization (WAO)-Kriterien bewertet worden sind. Insgesamt konnten neun randomisierte, doppelblind-plazebokontrollierte Allergoid-Studien in diese Analyse aufgenommen werden, nur sechs davon sind mit in Deutschland relevanten Allergenen durchgeführt worden. Auch die Patientenzahlen waren gering: in diese neun Studien waren insgesamt 494 erwachsene Patienten einbezogen. Studien zu Dosisfindung, Langzeit- und Präventionseffekten konnten nicht gefunden werden. Die Autoren kommen zu der Schluss\u00ADfolgerung, dass die Evidenz zur Wirksamkeit von Allergoiden nur auf wenige Präparate begrenzt zu sein scheint und empfehlen daher, den therapeutischen Einsatz derjenigen Allergoide, für die solche Wirksamkeitsnachweise fehlen, kritisch zu überdenken. Möglicherweise unwirksame Behandlungen sollten Patienten und der Solidargemeinschaft erspart werden (Bachert 2009).\n" +
                        "\n" +
                        "Die deutlich bessere Studienlage zur Allergie-Immuntherapie mit nativen Allergenen wurde in einer Arbeit von Bachert & Kollegen dargelegt. Die Autoren kommen hier zu dem Schluss, dass die für die spezifische subkutane Immuntherapie (SCIT) bekannten Erfahrungen und Kenntnisse sowohl zur nachhaltigen klinischen Wirksamkeit als auch zu den sekundär\u00ADpräventiven Effekten (z.B. Vermeidung von Asthma) auf den Ergebnissen von Studien mit nativen, d.h. nicht modifizierten Allergenpräparaten beruhen. Eine Verallgemeinerung dieser Effekte auf “die SCIT” generell wird nachdrücklich abgelehnt.\n" +
                        "\n" +
                        "Auch die aktuelle Leitlinie der Deutschsprachigen Fachgesellschaften zur (allergen-)spezifischen Immuntherapie (Pfaar 2014) äußert sich eindeutig zu diesem Thema und fordert eine produktspezi\u00ADfische Bewertung von Einzelpräparaten nach klar de\u00ADfinierten Kriterien: „Eine verallgemeinernde Übertragung der Wirksamkeit von Einzelpräparaten auf alle Präparate einer Applikationsform verbietet sich.“ Aus Sicht der Autoren sollten zugelassene Allergenpräparate oder im Rahmen der Therapieallergene-Verordnung (TAV) verkehrsfähige Präparate, die in mindestens einer klinischen Studie nach WAO- oder European Medicines Agency (EMA)-Standards eine Wirksamkeit und Sicherheit dokumentiert haben, bevorzugt eingesetzt werden.\n" +
                        "\n" +
                        "Präparate-spezifische Informationen zu den in Deutschland, der Schweiz und Österreich verfügbaren AIT-Produkten werden von den Fachgesellschaften in einer regelmäßig aktualisierten Tabelle zur Verfügung gestellt. Eine mindestens halbjährliche Aktualisierung ist geplant. Die Tabelle enthält ausschließlich Studien, die folgenden strengen Kriterien entsprechen:\n" +
                        "\n" +
                        "Standardisierter Allergenextrakt und Dosis\n" +
                        "Randomisiertes, doppelblind-plazebokontrolliertes Studiendesign\n" +
                        "Angabe eines Symptom-Medikationsscore und/oder beider Einzelscores\n" +
                        "Angaben zur statistischen Auswertung und statistisch signifikante Ergebnisse\n" +
                        "Die Wirksamkeit des Verum liegt mindestens 20 % über Plazebo\n" +
                        "Referenzen\n" +
                        "Lund L. et al, J Allergy Clin Immunol 2007; 37: 564-71\n" +
                        "Heydenreich B. et al.; Immunology. 2012; 136 (2): 208-17\n" +
                        "Rauber M.M. et al., Allergo J Int 2015; 24 (1): 26\n" +
                        "Ebner C. et al.; Clin Exp Allergy 1997; 27: 1007-15\n" +
                        "Dormann D. et al.; Clin Exp Allergy 1998; 28: 1374-83\n" +
                        "Lüderitz-Püchel U. et al., Bundesgesundheitsbl Gesundheitsforsch Gesundheitsschutz 2001; 44: 709-18\n" +
                        "Bachert C., et al., Allergologie 2009; 32 (3): 83-92 \n" +
                        "Bachert C. et al., Allergologie 2010; 33 (9): 379-94\n" +
                        "Pfaar O. et al., Leitlinie der DGAKI, Allergo J Int 2014, 23: 282-319\n" +
                        "Schmitt J. et al., J Allergy Clin Immunol 2015, 136 (6): 1511-16");
                break;
            case "In welchen Studien wurde der nachhaltige Therapieerfolg von GRAZAX® belegt?":
                antwort.setText("GRAZAX® ist die einzige Gräser-Impftablette mit nachgewiesener Wirksamkeit und entsprechender europaweiter Zulassung auch 2 Jahre nach Abschluss der Therapie.  \n" +
                        "\n" +
                        "GRAZAX® wurde am 25.09.2006 in 27 europäischen Ländern zugelassen und im November 2006 in Deutschland eingeführt. Seit November 2008 ist GRAZAX® auch für die Anwendung bei Kindern und Jugendlichen ab 5 Jahren zugelassen. Die Arbeitsgruppen um Ibañez und Bufe konnten die Sicherheit (Ibañez 2007) und die Wirksamkeit (Bufe 2009) auch für diese Altersgruppe nachweisen. Seit April 2014 liegt auch die Zulassung für die Gräser-Impftablette (unter dem Namen GRASTEK®) durch die FDA für den US-amerikanischen Markt vor. Als Basis hierfür dienten Studien in der Anwendung bei Erwachsenen (Nelson 2011) und bei Kindern (Blaiss 2011).\n" +
                        "\n" +
                        "Die hohe Wirksamkeit und das hervorragende Sicherheitsprofil von GRAZAX® wurden im bisher größten Studienprogramm zur Allergie-Immuntherapie dokumentiert (Malling 2006, Durham 2006, Kleine-Tebbe 2006, Dahl 2006a+b). In diesem Studienprogramm wurde ein Wirksamkeitsprofil ähnlich der subkutanen Allergie-Immuntherapie mit standardisierten Allergenpräparaten (Frew 2006) bei jedoch deutlich verbessertem Sicherheitsprofil nachgewiesen. Inzwischen wurden mehr als 8.000 Patienten in das klinische Studienprogramm mit GRAZAX® eingeschlossen.\n" +
                        "\n" +
                        "In einer multizentrischen Langzeitstudie (GT-08) wurde die Wirksamkeit von GRAZAX® randomisiert und doppelblind-plazebokontrolliert überprüft. Die Patienten erhielten über 3 Jahre entweder GRAZAX® oder Plazebo. Nach Beendigung der dreijährigen Therapie wurden die Patienten über weitere 2 Jahre nachbeobachtet.\n" +
                        "\n" +
                        "Unter Zugrundelegung des Rhinokonjunktivitis-Symptomscores konnte gezeigt werden, dass die Patienten, die GRAZAX® erhielten, bereits nach einem Jahr 32 % weniger Rhinokonjunktivitis-Symptome hatten als die Plazebo-Patienten. Auch der Bedarf an Symptomatika war bei den mit GRAZAX® behandelten Patienten im Vergleich zu Plazebo bereits nach einem Therapiejahr um 55 % reduziert.\n" +
                        "\n" +
                        "Die hohe und nachhaltige Wirksamkeit von GRAZAX® wird besonders deutlich, wenn man Medikamenten\u00ADscore und Symptomscore des 4. Jahres (1. Follow up-Jahr) betrachtet: Obwohl die zuvor mit GRAZAX® therapierten Patienten 52 % weniger Begleitmedikamente (Symptomatika) einnahmen, erreichten sie dennoch eine klinisch relevante Besserung ihrer Symptome um 31 % (Durham 2010). Anders ausgedrückt: Die mit Plazebo behandelten Patienten mussten doppelt so viele Symptomatika nehmen und erreichten dennoch nicht den Gesundheitszustand der mit GRAZAX® therapierten Patienten. Für den Vergleich wurden die Medianwerte herangezogen.\n" +
                        "\n" +
                        "Im 5. Jahr (2. Follow up-Jahr) zeigten die zuvor mit GRAZAX® behandelten Patienten weiterhin eine nachhaltige Verbesserung des kombinierten Medikamenten- und Symptom\u00ADscores um 33 % im Median. Außerdem waren anhaltende immunologische Effekte wie der Anstieg allergen-spezifischer IgG4-Antikörper und die Präsenz des IgE-blockierenden Faktors auch 2 Jahre nach Ende der Therapie nachweisbar (Durham 2012).\n" +
                        "\n" +
                        "Diese Ergebnisse wurden auch durch eine in den USA durchgeführte multizentrische, doppelblind-plazebo\u00ADkontrollierte Parallel\u00ADgruppenstudie mit 1.501 Patienten bestätigt. 19 % der hier untersuchten Patienten waren jünger als 18 Jahre, 85 % waren polysensibilisiert (Maloney 2014).\n" +
                        "\n" +
                        "Auch in der „GRAZAX Asthma Präventionsstudie“ (GAP), der bisher größten pädiatrischen Studie zur spezifischen Immuntherapie mit 812 Kindern, wurde der bereits für Erwachsene dokumentierte, krankheitsmodifizierende Effekt zwei Jahre nach Abschluss der Therapie nun auch für Kinder mit allergischer Rhinokonjunktivitis nachgewiesen (Valovirta 2017).\n" +
                        "\n" +
                        "Referenzen\n" +
                        "Malling HJ et al. J Invest Allergol Clin Immunol 2006, 16: 162-68\n" +
                        "Durham SR et al. J Allergy Clin Immunol 2006, 117: 802-09\n" +
                        "Kleine-Tebbe J et al. Allergy 2006, 61: 181-84\n" +
                        "Dahl R et al. Allergy 2006, 61: 185-90 a\n" +
                        "Dahl R et al. J Allergy Clin Immunol 2006, 118: 434 b\n" +
                        "Frew AJ et al. J Allergy Clin Immunol 2006, 117: 319-25\n" +
                        "Ibañez MD et al. Pediatr Allergy Immunol 2007, 18: 516-22\n" +
                        "Bufe A et al. J Allergy Clin Immunol 2009, 123: 167-73\n" +
                        "Durham SR et al. J Allergy Clin Immunol 2010, 125: 131-38\n" +
                        "Durham SR et al. J Allergy Clin Immunol 2012, 129 (3): 717-25\n" +
                        "Nelson HS et al. J. Allergy Clin Immunol 2011, 127 (1): 72-80\n" +
                        "Blaiss M et al. J. Allergy Clin. Immunol 2011, 127 (1): 64-71\n" +
                        "Maloney J et al., Ann Allergy Asthma Immunol 2014, 112: 146-53\n" +
                        "Valovirta E et al., Journal of Allergy and Clinical Immunology 2017, doi: 10.1016/j.jaci.2017.06.014");
                break;
            case "Welche Erfahrungen gibt es mit GRAZAX® beim Einsatz von Kindern und Jugendlichen?":
                antwort.setText("Es gibt bisher nur wenige Präparate, für die ein Wirksamkeitsnachweis bei Kindern und Jugendlichen erbracht wurde, und die explizit für diese Altersgruppe eine Zulassung vom Paul-Ehrlich Institut erhalten haben.\n" +
                        "\n" +
                        "GRAZAX® wurde am 25.09.2006 in 27 europäischen Ländern zugelassen und im November 2006 in Deutschland eingeführt (Studienübersicht in Möhrenschlager 2008). Seit November 2008 ist GRAZAX® auch für die Anwendung bei Kindern und Jugendlichen ab 5 Jahren zugelassen. Die Arbeitsgruppen um Ibañez und Bufe konnten die Sicherheit (Ibañez 2007) und die Wirksamkeit (Bufe 2009) auch für diese Altersgruppe nachweisen. Die Allergendosis betrug ebenfalls 75.000 SQ-T wie in der Anwendung bei Erwachsenen.\n" +
                        "\n" +
                        "In der Phase III-Studie von Bufe konnte an Kindern und Jugendlichen im Alter von 5 bis 16 Jahren gezeigt werden, dass in der Hochsaison des Gräserpollenflugs die Nasen\u00ADsymptomatik um 25 %, die Augensymptomatik um 37 % und der Medikamentenbedarf um 65 % im Median gesenkt werden konnte. Auch die Asthmasymptomatik war in der Verum\u00ADgruppe um 64 % niedriger als in der Kontrollgruppe (Bufe 2009).\n" +
                        "\n" +
                        "Auf Basis dieser Studien wurde im November 2008 von den europäischen Behörden die Zulassung für Kinder ab 5 Jahren erteilt.\n" +
                        "\n" +
                        "Die hohe und nachhaltige Wirksamkeit und gute Verträglichkeit von GRAZAX® wurde auch durch in den USA durchgeführte multizentrische, doppelblind-plazebokontrollierte Studien bestätigt (Blaiss 2011, Maloney 2014).\n" +
                        "\n" +
                        "Auch in der breiten Anwendung hat sich die gute Verträglichkeit von GRAZAX® bei Kindern bestätigt. Es hat sich dabei bewährt, die Ersteinnahme in der Praxis unter ärztlicher Aufsicht durchzuführen, um mit dem Patienten die relativ häufigen lokalen Nebenwirkungen zu besprechen, damit diese die Compliance des Patienten nicht beeinträchtigen.\n" +
                        "\n" +
                        "Um den Asthma-präventiven Effekt von GRAZAX® nachzuweisen, wurde von 2011 bis 2015 die „GRAZAX® Asthma Präventionsstudie“ (GAP) durchgeführt. Sie ist die bisher größte pädiatrische Studie zur spezifischen Immuntherapie und die erste doppelblind-placebokontrollierte, randomisierte Studie, die den präventiven Effekt der Immuntherapie auf Asthma untersucht (Valovirta 2011).\n" +
                        "\n" +
                        "Diese im November 2015 abgeschlossene Studie konnte zeigen, dass sich bei Kindern die Behandlung mit GRAZAX® positiv auf die Entwicklung von Asthmasymptomen und den Einsatz von Asthmamedikamenten auswirkt. Das Chancenverhältnis für das Auftreten von Asthmasymptomen1 oder den Einsatz von Asthmamedikamenten2  betrug am Ende des fünfjährigen Beobachtungszeitraums 0,66 (p < 0,05) zugunsten der GRAZAX®-Behandlung.\n" +
                        "\n" +
                        "Obwohl der primäre Endpunkt der Studie verfehlt wurde, konnte die GAP-Studie (Valovirta 2017) zeigen, dass\n" +
                        "\n" +
                        "GRAZAX den Anteil der Kinder, die Asthmasymptome1 entwickelten oder Asthmamedikamente2 einnahmen, signifikant reduzierte – ein Effekt, der sowohl in den Sommer- als auch in den Wintervisiten beobachtet wurde und auch über einen Zeitraum von zwei Jahren nach Therapieende erhalten blieb;\n" +
                        "je jünger die Kinder bei Therapiebeginn waren, umso geringer war die number needed to treat (NNT*) – ein Hinweis darauf, die Therapie früh im Kindesalter zu beginnen;\n" +
                        "       * NNT = Anzahl der Patienten, die behandelt werden müssen, um ein klinisches Ereignis innerhalb eines Zeitraums zu verhindern\n" +
                        "der bereits für Erwachsene nachgewiesene krankheitsmodifizierende Effekt auch 2 Jahre nach Therapieende nun erstmals auch für Kinder mit allergischer Rhinokonjunktivitis nachgewiesen wurde.\n" +
                        "1 Die Asthmasymptome umfassten Pfeifatmung, Engegefühl in der Brust, Kurzatmigkeit oder Husten an mehr als zehn aufeinanderfolgenden Tagen. \n" +
                        "2 Die Asthmamedikamente umfassten kurzwirkenden Beta-2-Agonisten (SABA), systemisches Kortikosteroid, inhalatives Kortikosteroid (ICS), Leukotrien-Rezeptor-Antagonist (LTRA), langwirkenden Beta-2-Agonisten (LABA), Theophyllin mit verzögerter Freisetzung oder  Cromoglycinsäure\n" +
                        "\n" +
                        "Referenzen\n" +
                        "M. Möhrenschlager et al., Allergologie 2008, 31(1): 23-35\n" +
                        "M.D. Ibañez et al., Pediatr Allergy Immunol 2007, 18:516-522\n" +
                        "A. Bufe et al., J Allergy Clin Immunol 2009, 123:167-173\n" +
                        "M. Blaiss et al., J Allergy Clin Immunol 2011, 127: 64-71\n" +
                        "J. Maloney et al., Ann Allergy Asthma Immunol 2014, 112: 146-53\n" +
                        "E. Valovirta et al., Clin Ther 2011, 33 (10): 1537-1546\n" +
                        "E. Valovirta et al., Journal of Allergy and Clinical Immunology (2017), doi: 10.1016/j.jaci.2017.06.014");
                break;
            case "Gibt es eine Verdünnungsanleitung für ALK-lyophilisiert SQ® Therapie Insektengiftpräparate?":
                antwort.setText("Anleitung zur Herstellung einer Anfangsbehandlung sowie des Intrakutantests aus der Flasche 4\n" +
                        "Die für die Dosissteigerung in der Anfangsbehandlung (Aufdosierung) benötigten Allergen\u00ADkonzentrationen können durch Verdünnung aus der Flasche 4 (100.000 SQ/ml) ALK-lyophilisiert SQ® Insektengift mit ALK-diluent hergestellt werden. Auch eine Lösung zur Intrakutantestung kann durch Verdünnung der Flasche 4 von ALK-lyophilisiert SQ® Bienen- bzw. Wespengift hergestellt werden.\n" +
                        "\n" +
                        "Für die Aufdosierung stehen zwei unterschiedliche Packungsgrößen zur Verfügung:\n" +
                        "\n" +
                        "Aufdosierungsset 1 besteht aus 1x Flasche 4 ALK-lyophilisiert SQ® Insektengift und 9x ALK-diluent. Dies ist in der Regel für eine Ultrarush-Aufdosierung ausreichend. Für die Ultra-Rush-Aufdosierung ist aus der Stammlösung von 4,5 ml einmal eine Entnahme von 0,55 ml zur Herstellung weiterer Verdünnungsstufen erforderlich sowie von 3,5 ml für weitere Injektionen mit der Konzentration der Stammlösung von 100.000 SQ/ml. Das bedeutet, dass für die Ultra-Rush-Aufdosierung ein Gesamtvolumen von 4,05 ml benötigt wird und das Aufdosierungsset 1 ausreicht, wenn keine Zwischenschritte erforderlich werden.\n" +
                        "\n" +
                        "Aufdosierungsset 2 besteht aus 2x Flasche 4 ALK-lyophilisiert SQ® Insektengift und 8x ALK-diluent. Für eine Rush-Aufdosierung ist aufgrund der Haltbarkeit der Verdünnungsstufen von jeweils 24 Stunden die Entnahme von 0,55 ml aus der Stammlösung zur Herstellung weiterer Verdünnungs\u00ADstufen an drei aufeinander folgenden Tagen erforderlich. Daher ergibt sich für die Rush-Aufdosierung ein benötigtes Gesamtvolumen von 3 x 0,55 ml und 5,5 ml für die weiteren Injektionen von insgesamt 7,15 ml. Hierfür wird das Aufdosierungsset 2 benötigt.\n" +
                        "\n" +
                        "Verdünnungsanleitung ALK-lyophilisiert SQ® Insektengifte Anfangsbehandlung\n" +
                        "\n" +
                        "Zum Gebrauch wird die aus dem Lyophilisat hergestellte Stammlösung (100 µg/ml, Flasche 4) verdünnt. Es empfiehlt sich die Verwendung albuminhaltiger Verdünnungslösung (ALK-diluent).\n" +
                        "\n" +
                        "Verdünnungsreihe:\n" +
                        "\n" +
                        "0,55 ml der Konzentration 100 µg/ml in 5 ml Verdünnungslösung\n" +
                        "ergeben 5,55 ml der Konzentration 10 µg/ml.\n" +
                        "0,55 ml der Konzentration 10 µg/ml in 5 ml Verdünnungslösung\n" +
                        "ergeben 5,55 ml der Konzentration 1 µg/ml.\n" +
                        "0,55 ml der Konzentration 1 µg/ml in 5 ml Verdünnungslösung\n" +
                        "ergeben 5,55 ml der Konzentration 0,1 µg/ml.\n" +
                        "Weitere Verdünnungen sind entsprechend herzustellen. Das Datum der Auflösung bzw. das sich daraus ableitende Verfalldatum muss sofort auf dem Flaschenetikett vermerkt werden. Die Stammlösung (Flasche 4) ist 3 Monate, alle Verdünnungen 24 Stunden haltbar.\n" +
                        "\n" +
                        "Verdünnungsanleitung ALK-lyophilisiert SQ® Insektengifte Intrakutantest\n" +
                        "\n" +
                        "Die höchste Konzentration, die für die Intrakutantestung eingesetzt wird, ist 1 µg/ml. Diese Konzentration wird wie oben beschrieben (Schritte 1. und 2.) hergestellt. Für die Testung werden weitere Konzentrationen benötigt, die ausgehend von der Lösung mit 1 µg/ml verdünnt werden. Es empfiehlt sich die Verwendung der albuminhaltigen Verdünnungs\u00ADlösung ALK-diluent.\n" +
                        "\n" +
                        "Verdünnungsreihe:\n" +
                        "\n" +
                        " 0,55 ml der Konzentration 1 µg/ml in 5 ml Verdünnungslösung\n" +
                        "ergeben 5,55 ml der Konzentration 0,1 µg/ml.\n" +
                        "0,55 ml der Konzentration 0,1 µg/ml in 5 ml Verdünnungslösung\n" +
                        "ergeben 5,55 ml der Konzentration 0,01 µg/ml.\n" +
                        "0,55 ml der Konzentration 0,01 µg/ml in 5 ml Verdünnungslösung\n" +
                        "ergeben 5,55 ml der Konzentration 0,001 µg/ml.\n" +
                        "Weitere Verdünnungen sind entsprechend herzustellen. Das Datum der Auflösung bzw. das sich daraus ableitende Verfalldatum muss sofort auf dem Flaschenetikett vermerkt werden. Die Stammlösung (Flasche 4) ist 3 Monate, alle Verdünnungen 24 Stunden haltbar.\n" +
                        "\n" +
                        "Alternative Verdünnungsreihe (zur Herstellung von kleineren Volumina zur Intrakutantestung):\n" +
                        "\n" +
                        "Zum Gebrauch wird die aus dem Lyophilisat hergestellte Stammlösung (100 µg/ml, Flasche 4) verdünnt.\n" +
                        "\n" +
                        "0,1 ml der Konzentration 100 µg/ml in 0,9 ml Verdünnungslösung\n" +
                        "ergeben 1 ml der Konzentration 10 µg/ml.\n" +
                        "0,1 ml der Konzentration 10 µg/ml in 0,9 ml Verdünnungslösung \n" +
                        "ergeben 1 ml der Konzentration 1 µg/ml.\n" +
                        "0,1 ml der Konzentration 1 µg/ml in 0,9 ml Verdünnungslösung\n" +
                        "ergeben 1 ml der Konzentration 0,1 µg/ml.\n" +
                        "0,1 ml der Konzentration 0,1 µg/ml in 0,9 ml Verdünnungslösung\n" +
                        "ergeben 1 ml der Konzentration 0,01 µg/ml.\n" +
                        "0,1 ml der Konzentration 0,01 µg/ml in 0,9 ml Verdünnungslösung\n" +
                        "ergeben 1 ml der Konzentration 0,001 µg/ml.\n" +
                        "Weitere Verdünnungen sind entsprechend herzustellen. Das Datum der Auflösung bzw. das sich daraus ableitende Verfalldatum muss sofort auf dem Flaschenetikett vermerkt werden. Die Stammlösung (Flasche 4) ist 3 Monate, alle Verdünnungen 24 Stunden haltbar.");
                break;
            case "Wie wirksam und verträglich sind die verschiedenen ALK-Insektengiftpräparate?":
                antwort.setText("Eine vergleichbare Wirksamkeit aller drei Präparate aus dem Hause ALK (Reless®, ALK-lyophilisiert SQ®, ALK-depot SQ®, jeweils Wespengift) wurde bereits 1986 nachgewiesen. Bedingt durch die Immunogenitätsverstärkende Wirkung des Aluminium\u00ADhydroxids stiegen die spezifischen IgG-Titer während der Behandlung mit ALK-depot signifikant höher an (Mosbech 1986).\n" +
                        "\n" +
                        "In einer weiteren Untersuchung von Sieber wurden die Nebenwirkungen von Reless® und ALK-lyophilisiert SQ® miteinander verglichen (Sieber 1996). Bezüglich der systemischen Neben\u00ADwirkungen bestand kein Unterschied zwischen Reless® und ALK-lyophilisiert SQ®, allerdings traten unter ALK-lyophilisiert SQ® weniger lokale Nebenwirkungen auf. Im Herstellungs\u00ADprozess von ALK SQ®-Präparaten werden sämtliche niedermolekularen, biogenen Bestandteile, die für die toxischen Lokalreaktionen verantwortlich sind, entfernt.\n" +
                        "\n" +
                        "Eine bessere lokale Verträglichkeit wird auch durch die Verwendung des Depotpräparates ALK-depot SQ® erreicht. Die ausgezeichnete Verträglichkeit wird durch eine langsamere Freisetzung des Giftes aus der Depotform erreicht (Wüthrich 1993, Wyss 1993). Ein weiterer Vorteil der Allergen\u00ADinjektionen mit ALK-depot SQ® sind die Injektionsintervalle in einem Abstand von 4 - 8 Wochen in der Erhaltungsphase. Bei ALK-depot sind die allergenen Komponenten an Aluminiumhydroxid adsorbiert. Wegen dieser Depotwirkung können die Intervalle zwischen den Injektionen während der Fortsetzungsbehandlung auf bis zu 8 Wochen ausgedehnt werden. Auch bei einem 8-wöchigen Intervall ist keine Dosisreduktion erforderlich. Des Weiteren liegt das Depotpräparat bereits als Suspension vor; es ist also keine Rekonstitution eines Lyophilisates notwendig.\n" +
                        "\n" +
                        "Aus diesen Gründen eignet sich ALK-depot SQ® besonders für die Insektengift-Immun\u00ADtherapie in der Praxis, während die wässrigen Darreichungsformen (ALK-lyophilisiert SQ® und Reless®) vorwiegend für die stationäre Schnellhyposensibilisierung eingesetzt werden, um einen möglichst schnellen Immunisierungsschutz zu erreichen. Hierfür wurden sogenannte Ultra-Rush-Verfahren konzipiert, so dass die Behandlungsdauer zwischen 3,5 und 6 Stunden (Auer 1995, Skrbic 1993) und 3 Tagen liegt (Brehler 2000). Das von Brehler entwickelte Ultrarush-Aufdosierungsprotokoll ist zugelassen für ALK-lyophilisiert SQ Insektengifte.\n" +
                        "\n" +
                        "Eine spezifische Allergie-Immuntherapie kann nach Vorbehandlung mit Reless® oder mit ALK-lyophilisiert SQ® Therapie Insektengiften jederzeit mit den ALK-depot SQ®-Insektengiften fortgeführt werden. 100 µg Insektengift Reless® bzw. ALK-lyophilisiert SQ® Insektengift entsprechen 100.000 SQ-Einheiten von ALK-depot SQ®, so dass Sie die Therapie mit 1,0 ml der Stärke 4 von ALK-depot SQ® fortsetzen können.\n" +
                        "\n" +
                        "Referenzen\n" +
                        "Mosbech H. et al.; Allergy 1986; 41: 95-103\n" +
                        "Sieber W.; Skandra T.; Allergo J 1996; 5: 38\n" +
                        "Wüthrich B. et al.; Allergo J 1993; 2: 95-102\n" +
                        "Wyss M. et al.; Allergy 1993; 48(2): 81-6\n" +
                        "Auer T. et al.; Akt Dermatol 1995; 21: 122-28\n" +
                        "Skrbic D. et al.; Allergo J 1993; 2: 31/51\n" +
                        "Brehler R. et al.; J Allergy Clin Immunol 2000; 105: 1231-35");
                break;
            case "Warum sind Verdünnungen der ALK-lyophilisiert SQ®- und Reless®-Präparate nur 24 Stunden haltbar?":
                antwort.setText("Mit den Präparaten Reless® und ALK-lyophilisiert SQ® für die Provokations- oder Intrakutan\u00ADtestung bietet ALK lyophilisierte (gefriergetrocknete) Allergene mit einer Konzentration von 100 µg/ml bzw. 100.000 SQ/ml an. Diese werden für die weitere Anwendung 1:10, 1:100, 1:1.000 oder auch noch weiter verdünnt.\n" +
                        "\n" +
                        "Mit der Überarbeitung der Europäischen Arzneibuch-Monographie für Allergenpräparate (2010) wurden die Anforderungen an die Produktqualität angehoben. An den geringeren Allergenkonzentrationen, hier also an den Verdünnungen, sind einige dieser neu verlangten Tests methodisch nicht durchführbar, so dass Stabilitätsstudien der Verdünnungen nicht möglich sind. Einer internationalen Qualitäts-Richtlinie entsprechend darf damit die angegebene Haltbarkeit 24 Stunden nicht überschreiten.\n" +
                        "\n" +
                        "ALK hat diese Anforderungen umgesetzt. Die geänderten Fach- und Gebrauchs\u00ADinformationen für ALK-lyophilisiert SQ® und Reless® wurden vom PEI zugelassen. Die ALK-Lyophilisate entsprechen damit voll und ganz dem aktuellen wissenschaftlichen Kenntnis\u00ADstand. Damit erfüllt ALK seinen Anspruch, nur Allergenpräparate von bester Qualität anzubieten.\n" +
                        "\n" +
                        "Referenz\n" +
                        "Monograph on allergen products – Producta Allergenica 01/2010: 1063. In: Council of Europe (Hrsg) European Pharmacopoeia, 6. Aufl. (suppl. 6), Strasbourg 2010, 679-80");
                break;
            case "Wie kann ich als Apotheke bei ALK bestellen?":
                antwort.setText("Per Telefon: 040-703845-100\n" +
                        "Per Fax: 040-703845-55 88\n" +
                        "Per Post: ALK-Abelló Arzneimittel GmbH, 22758 Hamburg\n" +
                        "Montag bis Freitag von 9:00 Uhr bis 17:00 Uhr");
                break;
            case "Fallen bei einer Bestellung Transportkosten an?":
                antwort.setText("Nein, ALK berechnet keine Transportkosten. Etwaige Mehrkosten fallen nur für Eilgut- oder Expresslieferungen an.");
                break;
            case "Was ist der Unterschied zwischen ALK-depot SQ® AF, F1 und F2?":
                antwort.setText("AF = Anfangsbehandlung\n" +
                        "4x5 ml (Flasche 1,2,3 und 4)\n" +
                        "\n" +
                        "F1 = Fortsetzungsbehandlung\n" +
                        "1x 5 ml (1x Stärke 4)\n" +
                        "\n" +
                        "F2 = Fortsetzungsbehandlung\n" +
                        "2x 5 ml (2x Stärke 4)");
                break;
            case "Warum brauchen Sie den Inhabernamen der Apotheke?":
                antwort.setText("ALK ist laut Steueränderungsgesetz verpflichtet, den Namen und die Anschrift des Leistungsempfängers nachzuweisen.");
                break;
            case "Ist mein Fax angekommen?":
                antwort.setText("Bitte kontrollieren sie Ihren Sendebericht. Weist dieser einen korrekten Sendevorgang aus, so erhalten Sie schnellstmöglichst von unserer Seite die Auftragsbestätigung.");
                break;
            case "Wann wird die bestellte Ware geliefert?":
                antwort.setText("Die Lieferfristen (einschließlich der Kurierdienstleistung) betragen im Regelfall:\n" +
                        "\n" +
                        "Wann wird die bestellte Ware geliefert? Die Lieferfristen (einschließlich der Kurierdienstleistung) betragen im Regelfall: 24-48 Stunden für zugelassene Fertigarzneimittel 7 Werktage für individuelle Rezepturen.");
                break;
        }
    }
}
