package Lesson03_Exeption_Symbol;

public class SymbolArr 
{
	Symbol sArr[];
	int curr;
        
	public SymbolArr(int size){
		sArr = new Symbol[size];
		curr = 0;
	}
        //out of memort this exeption save in java
	public void add(Symbol sym)throws Exception
        {
		if (curr < sArr.length){
			sArr[curr++] = new Symbol(sym);
		}
		else{
			throw new OutOfMemoryError("Try to add to full array");
		}
	}
	public void remove(String name, int value)throws Exception{
		if (curr > 0)
                {
			
		}
		else{
			throw new Exception("Try to remove from empty array");
		}
	}
	
	public int getValue(String name)throws Exception{
		int ans = -1;
		for (int i=0; ans==-1 && i<sArr.length; i++) {
			if (sArr[i].getName() == name)
                            return sArr[i].getValue();
		}
		throw new Exception("Symbol not found");
	}
	public void set(String name, int newValue) throws Exception
        {
		boolean flag = false;
		for (int i=0; !flag && i<curr; i++) {
			if (name.equals(this.sArr[i].getName())){
				this.sArr[i].setValue(newValue);
				flag = true;
			}
		}
		if (!flag)
                    add(new Symbol(name, newValue));
	}
	public static void main(String[] args) {
		SymbolArr st = new SymbolArr(3);
		try {
			st.add(new Symbol("var1", 34));
			st.add(new Symbol("var2", 456));
			st.add(new Symbol("var3", 789));
			st.add(new Symbol("var4", -786));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
