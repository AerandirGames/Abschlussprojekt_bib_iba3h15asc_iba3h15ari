package com.example.kai.appalk;

/**
 * Created by Kai on 09.03.2018.
 */
public class User
{


    private String anrede, titel, vorname, name, eMail, telNr, pw, praxis, adresse, plz, stadt, praxisNr, praxisMail;

    public User(String anrede, String titel, String vorname, String name, String eMail, String telNr, String pw,
                String praxis, String adresse, String plz, String stadt, String praxisNr, String praxisMail)
    {
        if (!anrede.isEmpty() && !anrede.equals(""))
        {
            this.anrede = anrede;
        }

        this.titel = titel;

        if (!vorname.isEmpty() && !vorname.equals(""))
        {
            this.vorname = vorname;
        }
        if (!name.isEmpty() && !name.equals(""))
        {
            this.name = name;
        }
        if (!eMail.isEmpty() && !eMail.equals(""))
        {
            this.eMail = eMail;
        }
        if (!telNr.isEmpty() && !telNr.equals(""))
        {
            this.telNr = telNr;
        }
        if (!pw.isEmpty() && !pw.equals(""))
        {
            this.pw = pw;
        }
        this.praxis = praxis;
        this.adresse = adresse;
        this.plz = plz;
        this.stadt = stadt;
        this.praxisNr = praxisNr;
        this.praxisMail = praxisMail;
    }

    public User()
    {
        this.anrede = "Herr";
        this.titel = null;
        this.vorname = "ERROR";
        this.name = "ERROR";
        this.eMail = "error@error.com";
        this.telNr = "00000000000";
        this.pw = "root";
        this.praxis = null;
        this.adresse = null;
        this.plz = null;
        this.stadt = null;
        this.praxisNr = null;
        this.praxisMail = null;
    }

    public String getAnrede()
    {
        return anrede;
    }

    public void setAnrede(String anrede)
    {
        this.anrede = anrede;
    }

    public String getTitel()
    {
        return titel;
    }

    public void setTitel(String titel)
    {
        this.titel = titel;
    }

    public String getVorname()
    {
        return vorname;
    }

    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String geteMail()
    {
        return eMail;
    }

    public void seteMail(String eMail)
    {
        this.eMail = eMail;
    }

    public String getTelNr()
    {
        return telNr;
    }

    public void setTelNr(String telNr)
    {
        this.telNr = telNr;
    }

    public String getPw()
    {
        return pw;
    }

    public void setPw(String pw)
    {
        this.pw = pw;
    }

    public String getPraxis()
    {
        return praxis;
    }

    public void setPraxis(String praxis)
    {
        this.praxis = praxis;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public String getPlz()
    {
        return plz;
    }

    public void setPlz(String plz)
    {
        this.plz = plz;
    }

    public String getStadt()
    {
        return stadt;
    }

    public void setStadt(String stadt)
    {
        this.stadt = stadt;
    }

    public String getPraxisNr()
    {
        return praxisNr;
    }

    public void setPraxisNr(String praxisNr)
    {
        this.praxisNr = praxisNr;
    }

    public String getPraxisMail()
    {
        return praxisMail;
    }

    public void setPraxisMail(String praxisMail)
    {
        this.praxisMail = praxisMail;
    }
}
