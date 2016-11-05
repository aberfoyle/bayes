(defn get_prior [hypothesis] (let [[likelihood prior] hypothesis] prior)) (defn
get_priors [hypotheses] (map (fn[h] (get_prior h)) hypotheses) )

(defn get_likelihood [hypothesis] (let [[likelihood prior] hypothesis]
likelihood)) (defn sum_of_hypotheses [hypotheses] (reduce + (get_priors
hypotheses)))

(defn normalise_hypothesis [hypothesis sum]( let [likelihood (get_likelihood
hypothesis) prior (get_prior hypothesis)] [likelihood  (/ prior sum)]) )

(defn normalise [hypotheses] ( let [sum (sum_of_hypotheses hypotheses)] (into []
(map (fn [h] (normalise_hypothesis h sum)) hypotheses)) ) )

(defn update_hypothesis [hypothesis data](let [likelihood (get_likelihood
hypothesis)] [likelihood (* (likelihood data) (get_prior hypothesis))]

 ) )

(defn update_hypotheses [hypotheses data] ( normalise ( map (fn[h]
(update_hypothesis h data)) hypotheses) ) )

(defn update_all [hypotheses data] ( reduce (fn[h d] (update_hypotheses h d))
hypotheses data) )

(defn range_likelihood[start size] ( fn[data] ( if (or (> data (+ start size)) (<
data start)) 0 (/ 1 size))))

  (defn dice [size] (fn[data] (if (> data size) 0 (/ 1 size)))) (def four [(dice
  4) 1]) (def six [(dice 6) 1]) (def twenty [(dice 20) 1])

  (def hypotheses (normalise [four six twenty]))

(update_hypotheses hypotheses 3)

(update_all hypotheses [1 2 4 2])

(normalise_hypothesis four 3)

(sum_of_hypotheses hypotheses) (normalise hypotheses) (into [] (normalise
hypotheses)) 
