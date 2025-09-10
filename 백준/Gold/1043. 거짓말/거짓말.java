import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static boolean[] isTruth;

    // x의 루트 찾기
    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // 이렇게 써야 경로 압축이 됨
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        // 한쪽이 진실 그룹이면 다른 쪽도 진실 그룹에 편입
        if (isTruth[a]) {
            parent[b] = a;
        } else if (isTruth[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        isTruth = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truthCount; i++) {
            isTruth[Integer.parseInt(st.nextToken())] = true;
        }

        ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyMemberCount = Integer.parseInt(st.nextToken());
            ArrayList<Integer> party = new ArrayList<>();
            for (int j = 0; j < partyMemberCount; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        // 파티원들을 같은 집합으로 묶고, 진실 그룹을 전파
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> party = parties.get(i);
            if (party.size() > 1) {
                for (int j = 0; j < party.size() - 1; j++) {
                    union(party.get(j), party.get(j + 1));
                }
            }
        }

        // union 과정에서 진실이 전파된 사람들을 최종적으로 isTruth 배열에 반영
        for(int i = 1; i <= N; i++) {
            if(isTruth[find(i)]) {
                isTruth[i] = true;
            }
        }

        int liePartyCount = 0;
        for (ArrayList<Integer> party : parties) {
            boolean canLie = true;
            for (int member : party) {
                if (isTruth[find(member)]) { // 이 조건이 핵심
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                liePartyCount++;
            }
        }

        bw.write(liePartyCount + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}
