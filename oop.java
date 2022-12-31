import java.util.*;
import java.io.*;
import java.lang.*;

class student
{
    Scanner studc=new Scanner(System.in);
    String checkstud() throws Exception
    {
        File f1=new File("stddata.txt");
        FileReader fr=new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        String[] words;
        String stemp;
        System.out.println("Enter Student Roll:");
        String studcheck=studc.nextLine();
    
        while((stemp=br.readLine())!=null)
        {
            words=stemp.split("\n");  //Split the word using space
            for (String word : words)
            {
                if (word.equals(studcheck))   //Search for the given word
                {
                    return word;
                }
            }
        }
        System.out.println("Enter Correct Roll No.");
    return null;
        
    }
    void displaymarksheet(String ffinal) throws Exception
    {
        String sstemp;
        String ffinalf=ffinal+".txt";
        BufferedReader in = new BufferedReader(new FileReader(ffinalf));
        while ((sstemp=in.readLine()) != null) {
              System.out.println(sstemp);
        }
        in.close();
    }
    
    
}
class faculty extends student
{
    Scanner fc=new Scanner(System.in);
    String subcheck() throws Exception
    {
        
        
            File f1=new File("facdatac.txt");
            FileReader fr=new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String[] words;
            String stemp;
            System.out.println("Enter Course Name:");
            String subcheck=fc.nextLine();
        
            while((stemp=br.readLine())!=null)
            {
                words=stemp.split("\n");  //Split the word using space
                for (String word : words)
                {
                    if (word.equals(subcheck))   //Search for the given word
                    {
                        return word;
                    }
                }
            }
            System.out.println("Course Not Registered! Enter Valid Course Name.");
        return null;
        
    }
    
    void marksentry(String facfinalsub) throws Exception
    {
        System.out.println("Roll No\tMarks");
        File f1=new File("stddata.txt");
        FileReader fr=new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        String stemp=new String();
        int valmark=0;
        while((stemp=br.readLine())!=null)
        {
            while(true)
            {
                System.out.print(stemp+"\t");
                try{
                    valmark=fc.nextInt();
                    if(valmark>=0 && valmark<=100)
                    {
                        break;
                    }
                    else{
                        System.out.println("Enter Valid Marks");
                        continue;
                    }
                    
                }catch(Exception e){
                    System.out.println("Please Enter Valid Input");
                    String flush="";
                    flush=fc.nextLine();
                    continue;
                }
                
            }
            String sfroll=stemp+".txt";
            FileOutputStream fo12=new FileOutputStream(sfroll,true);
                
            String sample1=facfinalsub+"\t";
            char[] sample1array=sample1.toCharArray();
            for(int i=0;i<sample1.length();i++)
            fo12.write(sample1array[i]);
            String sample2=""+valmark+"\n";
            char[] sample2array=sample2.toCharArray();
            for(int i=0;i<sample2.length();i++)
            fo12.write(sample2array[i]);
        }
        
    }
}
class admin extends faculty
{
    Scanner sa=new Scanner(System.in);
    String apassword="admin";
    
    String checkpass()
    {
        while(true)
        {
        System.out.println("Enter Password:");
        String pass=sa.nextLine();
            if(apassword.equals(pass))
            {
                return apassword;
            }
            System.out.println("Enter Valid Password");
            break;
        }
        return null;
    }
    
    void addstud() throws Exception    //Add Student Details
    {
        String sname=new String();
        String sroll=new String();
        
        
        int flag=0;
        while(true)
        {
            
                System.out.println("Enter Student Name=");
                sname=sa.nextLine();
                for(int i=0;i<sname.length();i++)
                {
                    if((sname.charAt(i)>=65 && sname.charAt(i)<=91)||(sname.charAt(i)>=97 && sname.charAt(i)<=122))
                    {
                        flag=1;
                    }
                    else
                    {
                        flag=0; break;
                    }
                }
                if(flag==1)break;
            System.out.println("Enter Valid Name\n");
            
        }
        System.out.println("Enter Student Roll No.=");
        sroll=sa.nextLine();
        String tempsname=sroll+".txt";
        
        try{
        File file=new File(tempsname);
        file.createNewFile();
        }catch (IOException e) {
        System.out.println("Exception Occurred:");
        e.printStackTrace();}
        
        char[] snamearray= sname.toCharArray();
        char[] srollarray= sroll.toCharArray();
        FileOutputStream fo1=new FileOutputStream("stddata.txt",true);

        FileOutputStream fo2=new FileOutputStream(tempsname,true);
        
        String sd1="\t\t\tYOUR RESULT\n";
        String sd2="\t\t College:\t"+"Nirma University\n";
        char[] sd1array=sd1.toCharArray();
        char[] sd2array=sd2.toCharArray();
        for(int i=0;i<sd1.length();i++){
            fo2.write(sd1array[i]);
        }
        for(int i=0;i<sd2.length();i++){
            fo2.write(sd2array[i]);
        }
        for(int i=0;i<sname.length();i++){
            fo2.write(snamearray[i]);
        }
        fo2.write('\t');
        for(int i=0;i<sroll.length();i++){
            fo1.write(srollarray[i]);
            fo2.write(srollarray[i]);
        }
        fo1.write('\n');
        fo2.write('\n');
        
    }
    
    void addfac() throws Exception    //Add Student Details
    {
        String fname=new String();
        String fsub=new String();
        
        int flag1=0;
               while(true)
               {
                   
                       System.out.println("Enter Faculty Name=");
                       fname=sa.nextLine();
                       for(int i=0;i<fname.length();i++)
                       {
                           if((fname.charAt(i)>=65 && fname.charAt(i)<=91)||(fname.charAt(i)>=97 && fname.charAt(i)<=122))
                           {
                               flag1=1;
                           }
                           else
                           {
                               flag1=0; break;
                           }
                       }
                       if(flag1==1)break;
                   System.out.println("Enter Valid Name\n");
                   
               }
        
        
        int flag2=0;
               while(true)
               {
                   
                       System.out.println("Enter Course Name=");
                       fsub=sa.nextLine();
                       for(int i=0;i<fsub.length();i++)
                       {
                           if((fsub.charAt(i)>=65 && fsub.charAt(i)<=91)||(fsub.charAt(i)>=97 && fsub.charAt(i)<=122))
                           {
                               flag2=1;
                           }
                           else
                           {
                               flag2=0; break;
                           }
                       }
                       if(flag2==1)break;
                   System.out.println("Enter Valid Course\n");
                   
               }
        
        String tempfsub=fsub+".txt";
        
        char[] fsubarray= fsub.toCharArray();
        FileOutputStream fo1=new FileOutputStream("facdatac.txt",true);
        
        for(int i=0;i<fsub.length();i++){
            fo1.write(fsubarray[i]);
        }
        fo1.write('\n');
    }
}

class oop
{

    public static void main(String args[])throws Exception
    {
        System.out.println("\n\n\t***************************");
        System.out.println("\t*Student Mark Entry System*");
        System.out.println("\t***************************\n\n");
    Scanner sc=new Scanner(System.in);
    student stud=new student();
    faculty f=new faculty();
    admin a=new admin();
        int who=0;
    
        while(who!=4)
        {
            System.out.println("****** Enter Your Choice ******\n");
            System.out.println("1)Admin\n2)Faculty\n3)Student\n4)Exit");
            try{
                           who=sc.nextInt();
                           if(who>4||who<1)
                           {
                               System.out.println("Enter Number in Range");
                           }
                           //break;
                       }
                       catch(Exception e){
                           System.out.println("Please Enter Valid Input");
                           String flush="";
                           flush=sc.nextLine();
                           continue;
                       }
            //Admin Starts from Here
            if(who==1)
            {
                System.out.println("****** Admin ******\n");
                String admintemp=a.checkpass();
                if(admintemp==null)continue;

                int achoice=0;
                
                while(achoice!=4)
                {
                    System.out.println("\n1)Add New Entry\n2)Add Course\n3)Show Student\n4)Exit");
                    try{
                    achoice=sc.nextInt();
                    }
                    catch(Exception e){
                        System.out.println("Please Enter Valid Input");
                        String flush="";
                        flush=sc.nextLine();
                        continue;
                    }
                    switch(achoice)
                    {
                        case 1: a.addstud();
                            break;
                        case 2: a.addfac();
                            break;
                        case 3: String atemp=new String();
                        atemp=stud.checkstud();
                        if(atemp==null)continue;
                        stud.displaymarksheet(atemp);
                        break;
                        default: System.out.println("Enter Valid Output");
                    }
                    

                }

            }
            if(who==2)
            {
                System.out.println("****** Faculty ******\n");
                int fchoice=0;
                String facfinalsub=f.subcheck();
                if(facfinalsub==null) continue;
                while(fchoice!=2)
                {
                    System.out.println("\n1)Marks Entry\n2)Exit");
                    try{
                        fchoice=sc.nextInt();
                    }catch(Exception e){
                        System.out.println("Please Enter Valid Input");
                        String flush="";
                        flush=sc.nextLine();
                        continue;
                    }
                    switch(fchoice)
                    {
                        case 1: f.marksentry(facfinalsub);
                            break;
                        case 2: break;
                        default: System.out.println("Enter Valid Input");
                    }
                }
            }
            
            if(who==3)
            {
                String ftemp=new String();
                ftemp=stud.checkstud();
                if(ftemp==null)continue;
                stud.displaymarksheet(ftemp);
            }
            if(who==4)break;
        }//End of While Loop
    }
    
}