class StockSpanner 
{
  List<Integer> list;
  public StockSpanner() 
  {
    this.list = new ArrayList<>();
  }

  public int next(int price) 
  {
    list.add(price);
    int count = 0;
    for (int i = list.size() - 1; i >= 0; i--) 
    {
      if (list.get(i) > price)
        break;
      count++;
    }
    return count;
  }

  public int[] calculateSpans(int[] prices) 
  {

    int[] spans = new int[prices.length];
    spans[0] = 1; 
    Stack<Integer> st = new Stack<>();

    st.push(0);

    for (int i = 1; i < prices.length; i++) {
      while (!st.isEmpty()
          && prices[st.peek()] < prices[i])
        st.pop();

      if (st.isEmpty())
        spans[i] = i + 1;
      else
        spans[i] = i - st.peek();

      st.push(i);
    }
    return spans;
  }
}