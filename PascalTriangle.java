/**
 * Created by Baiye on 2016/11/22.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode.118.Pascal's Triangle
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        if(numRows == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> p = new ArrayList<Integer>();
        List<Integer> tempResult = new ArrayList<Integer>();
        for(int i = 0;i < numRows;i++)
        {
            tempResult = new ArrayList<Integer>();
            if(p.size() == 0 && i == 0)
            {
                tempResult.add(1);
                result.add(tempResult);
                p = tempResult;
            }
            else
            {
                for (int i1 = 0; i1 <= p.size(); i1++) {
                    if(i1 >= p.size())
                        tempResult.add(1);
                    else
                    {
                        if(i1 - 1 < 0)
                        {
                            tempResult.add(1);
                        }
                        else
                            tempResult.add(p.get(i1) + p.get(i1 - 1));
                    }
                }
                result.add(tempResult);
                p = tempResult;
            }


        }

        return result;
    }
}
