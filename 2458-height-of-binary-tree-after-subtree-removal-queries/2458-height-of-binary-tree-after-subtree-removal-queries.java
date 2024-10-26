class Solution {
    Map<Integer,Integer> height=new HashMap<>();
    Map<Integer,Integer> level=new HashMap<>();
    Map<Integer,Queue<Integer>> twoMaximum=new HashMap<>();

    int nodeHeight(TreeNode root,int l){
        
        if(root==null) 
        return -1;

        twoMaximum.putIfAbsent(l,new PriorityQueue<>());
        
        int temp=Math.max(nodeHeight(root.left,l+1),nodeHeight(root.right,l+1))+1;
        
        height.put(root.val,temp);
        level.put(root.val,l);
        
        twoMaximum.get(l).add(temp);
        
        if(twoMaximum.get(l).size()>2) 
        twoMaximum.get(l).remove();
        return temp;

    }
    public int[] treeQueries(TreeNode root, int[] q) 
    {
        int h=nodeHeight(root,0);
        for(int i=0;i<q.length;i++)
        {
            int lev=level.get(q[i]);
            int hh=height.get(q[i]);     
            int a=-1,b=-1;
            if(twoMaximum.get(lev).size()==2)
            {
                b=twoMaximum.get(lev).remove();
                a=twoMaximum.get(lev).remove();
                
                if(hh==a) 
                q[i]=h-(a-b);
                else 
                q[i]=h;
                
                twoMaximum.get(lev).add(a);
                twoMaximum.get(lev).add(b);
            }
            else 
            q[i]=h-hh-1;
        }
        return q;
    }
}