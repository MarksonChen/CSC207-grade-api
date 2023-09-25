package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        String[] teamMembers = gradeDB.getMyTeam().getMembers();
        int totalScore = 0;
        for(String member: teamMembers){
            System.out.println(member);
            totalScore += gradeDB.getGrade(member, course).getGrade();
            System.out.println(gradeDB.getGrade(member, course).getGrade());
        }
        return (float)totalScore / teamMembers.length;
    }
}
