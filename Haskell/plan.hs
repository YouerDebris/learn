type PlanName = String
type Partner = [String]
type Todo = String

data Plan = Plan {
  planName :: PlanName,
  partner :: Partner,
  todo :: Todo
                 }

data Activity = DoHomeWork
                             | GoForAWalk
                             | Learn
