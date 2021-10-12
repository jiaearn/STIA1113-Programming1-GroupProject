import java.util.Scanner;
public class Group_Project
{
static Scanner scan = new Scanner(System.in);
   public static void main(String args[])
   {
   String [][] arr =  new String[100][5];
   int row=0;
   int choice;
   int count=0;
   
   do {
   menu();
   System.out.print("Your choice: "); 
   choice=scan.nextInt();
   System.out.println("");
   if (choice==0){
    System.out.println("Thank you and Bye."); 
   break;
    }
   else
   count=processChoice(arr, choice, row, count);
   } while (choice!=0);
   }//end main

static void menu(){
 System.out.println(":::::::: MENU :::::::::\n"
                   +"1. Add Item\n"
                   +"2. Edit Item\n"
                   +"3. Remove Item\n"
                   +"4. Display\n"
                   +"5. Search\n"
                   +"0. EXIT");
                   }//menu
                   
 static int processChoice(String [][] arr, int choice, int row, int count){
 switch(choice){
  case 1: count=addItem(count,arr,row); break;
  case 2: editItem(arr,count); break;
  case 3: count=removeItem(arr,count); break;
  case 4: display(count,arr,row); break;
  case 5: search(count,arr,row); break;
  default: System.out.println("Sorry your choice is not in the list. Please choose again.");
  }//switch
  return count;
}//processChoice


static int addItem(int count, String [][] arr,int row){
  if (count < arr.length){
  System.out.print("Please insert the number of driver that you want to save: ");
  int number_of_row = scan.nextInt();
  
  for (row = 0 ; row < number_of_row ; row++)
      {
      int driving_experience;
      System.out.println("Driver " + (count+1) + ": ");
      
      System.out.print("Please enter driver name: ");
      arr[count][0] = scan.next() + scan.nextLine();
      
      System.out.print("Please enter driver IC.no (must include \"-\" symbol): ");
      arr[count][1] = scan.next() + scan.nextLine();
      while (arr[count][1].length() != 14)
      {
         System.out.println("The number of characters that entered was incorrect.");
         System.out.print("Please enter driver IC.no (must include \"-\" symbol): ");
         arr[count][1] = scan.next() + scan.nextLine();
      }   
      
      System.out.print("Please enter driver phone.no (must include \"-\" symbol): ");
      arr[count][2] = scan.next() + scan.nextLine();
      while ( arr[count][2].length() < 11 || arr[count][2].length() > 12 )
      {
      System.out.println("The number of characters that entered was incorrect.");
      System.out.print("Please enter driver phone.no (must include \"-\" symbol): ");
      arr[count][2] = scan.next() + scan.nextLine();
      }   
      
      System.out.println("Please enter driver status:");
      System.out.println("1 = Single");
      System.out.println("2 = Married");
      System.out.println("3 = Divorced");
      System.out.println("4 = Widowed");
      int z = scan.nextInt();
      switch (z)
      {
      case 1:
      arr[count][3] = "Single";
      break;
      case 2:
      arr[count][3] = "Married";
      break;
      case 3:
      arr[count][3] = "Divorced";
      break;
      case 4:
      arr[count][3] = "Widowed";
      break;
      default:
      arr[count][3]= "Error!!";
      break;
      }
      
      System.out.print("Please enter driver driving experience in year: ");
      driving_experience  = scan.nextInt() ;
      if (driving_experience <= 2)
         {
         arr[count][4] = driving_experience + " junior driver";
         }
      if (driving_experience >= 3 && driving_experience <= 7)
         {
         arr[count][4] = driving_experience + " senior driver";
         }
      if (driving_experience > 7)
         {
         arr[count][4] = driving_experience + " expert driver";
         }
      System.out.println();
      count++;
      }
  }
  else
    System.out.println("List is FULL.");
 return count;
}//addItem

static void editItem(String [][] arr, int count)
{
String name;
boolean cari = false;
if (count == 0)
   System.out.println("Sorry list is empty.");
   else {
    System.out.print("Edit name?: ");
    name = scan.next() + scan.nextLine();
    for (int i=0; i<count;i++)
    for (int j=0; j<5;j++){
     if (arr[i][j].equals(name)){
          System.out.print("New name to add?: ");
          name= scan.next() + scan.nextLine();
          arr[i][j]=name;
          cari=true;
          System.out.println();
          break;
          }
        }
        if (cari==false)
         System.out.println("Sorry your search value is not in the list.");
   }    
}//end editItem

static int removeItem(String [][] arr,int count){
   int i,j;
   String name;
   boolean delete=false;
   if (count==0)
     System.out.println("Sorry list is empty.");
  else {
  System.out.print("Information of driver to be deleted by inserting the name of driver: ");
  name= scan.next() + scan.nextLine();
  for ( i=0; i<count;i++)
     if (arr[i][0].equals(name)){
        for(j=i;j<count-1;j++)
        for( int k=0 ; k<5 ; k++)
           arr[j][k]=arr[j+1][k];
        --count;
         delete=true;
      System.out.println();
      break;
      }
    }
   if (delete==false)
   System.out.println("Sorry the number is not in the list.");
   return count;
  }//end removeItem

static void display(int count,String [][] arr,int row){
     if (count==0)
          System.out.println("Sorry list is empty.");
      
      System.out.println("****");
      System.out.println("E-Transport Management System (ETMS)");
      System.out.println("Driver Module");
      System.out.println("****");

      System.out.printf("%3s %24s %33s %14s %11s %30s\n","No", "Name","Identity Card Number",
                        "Phone.no", "Status" , "Driving Experience (year)");
       for (row = 0 ; row < count ; row++)
      {
      System.out.printf("%3d %10s %-30s", (row + 1),"         " ,arr[row][0]);
      System.out.printf("%12s ", arr[row][1]);
      System.out.printf("%5s%13s "," " ,arr[row][2]);
      System.out.printf("%10s ", arr[row][3]);
      System.out.printf("%25s\n", arr[row][4]);
      }
      System.out.println("");
}//end display

static void search(int count,String[][] arr,int row ){
  String name;
  boolean cari=false;
  if (count==0)
    System.out.println("Sorry list is empty.");
  else {
    System.out.print("Search for any name?: ");
    name=scan.next();
    for (row = 0 ; row < count ; row++){
     if (arr[row][0].equals(name)){
      cari=true;
      System.out.println("Name that you searched is at list which is driver number "+(row+1));
      System.out.println("");
      break;
     }
    }
    if (cari==false)
     System.out.println("Sorry name that you searcherd is not in the list.");
     System.out.println("");
   }    
  }//end search
}//end class