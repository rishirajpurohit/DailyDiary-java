import java.io.*;


class mywriter{
		mywriter(){
		
		System.out.println("*****__________Welcome to File Entry Menu__________*****\n");
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		FileWriter outs = null;
		try{
			System.out.print("\t1. Enter a Name  : ");
			String ename = input.readLine();
			System.out.print("\t2. Enter Title   : ");
			String etitle = input.readLine();
			System.out.print("\t3. Enter Content : ");
			String econt = input.readLine();
			try{
				System.out.println("\n\n\tCreating the space . . . . . ");
				
				File outfile = new File(ename+".txt");
				outs = new FileWriter(outfile);
				
				System.out.println("\tWriting the content . . . . . ");
				
				outs.write(etitle);
				outs.write("&");
				outs.write(econt);
				
				System.out.println("\tSaving the File . . . . . ");
				System.out.println("\tDone !!");

			}
			catch(IOException e){
				System.out.println(e);
				System.exit(-1);
			}
		}
		catch(Exception e){
			System.out.println("Error Occured in I/O");
		}
		finally{
			try{
				outs.close();
			}
			catch(IOException e){}
		}
	}
}


class myreader{
	myreader(){

		System.out.print("\n\tEnter the name of the file : ");
		FileReader ins = null;
		try{
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader input = new BufferedReader(reader);
			String ename = input.readLine();
			File infile = new File(ename+".txt");
			ins = new FileReader(infile);
			int ch,j;
			System.out.print("\n\n\tTitle is : ");
				for(j=0;(j=ins.read())!='&';j++)
					System.out.print((char)j);

			System.out.print("\n\n\tAnd Content is : ");
				for(int k=j;(k=ins.read()) != -1;k++ )
					System.out.print((char)k);
			
			/*while((ch =	ins.read())!= '&'){
				System.out.print((char)ch);
			}*/
			//rest is the content
		}
		catch(IOException e){
			System.out.println(e);
		}

	}
}


class Rex{
	public static void main(String[] args) {
		
		System.out.println("*****__________Welcome to Daily Diary__________*****\n");
		try{
			System.out.print("\n\tEnter Password : ");
			InputStreamReader reader1 = new InputStreamReader(System.in);
			BufferedReader input = new BufferedReader(reader1);
			String syspassword = "rex";
			String upassword = input.readLine();
			if (syspassword.equals(upassword)) {
				
				System.out.println("\n\t1. Create a Entry");
				System.out.println("\n\t2. Read a Entry");
				System.out.println("\n\t3. Delete a Entry");
				System.out.println("\n\t4. Exit");
				System.out.print("\n\n\n\tEnter A Choice : ");

				int choice = Integer.parseInt(input.readLine());
				System.out.println("\n\tYour choice : "+choice);
				switch(choice){
					case 1: mywriter entry = new mywriter();
							break;
					case 2: myreader reading = new myreader();
							break;
					case 3: System.out.println("Ubho re Lya !!");
							break;
					case 4: System.out.println("\n\tThanks For Using This Software");
							System.exit(-1);
							break;
					default: System.out.println("Try Again with correct choice.");
							break;
				}
				
			}
			else{
				System.out.println("You've enetred wrong Password = "+upassword);
				System.exit(-1);
			}
		}
		catch(IOException e){
			System.out.println(e);
			System.exit(-1);
		}
		//mywriter entry = new mywriter();


	}
}