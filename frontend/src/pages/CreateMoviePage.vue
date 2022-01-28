<template>
  <div class="box">
    <div class="field">
      <label class="label">Название фильма</label>
      <div class="control">
        <input v-model="name" class="input" type="text">
      </div>
    </div>
    <div class="field">
      <label class="label">Год</label>
      <div class="control">
        <input v-model="year" class="input" type="number" min="1800" max="2030">
      </div>
    </div>
    <div class="field">
      <label class="label">Продолжительность</label>
      <div class="control">
        <input v-model="duration" class="input" type="number" min="0">
      </div>
    </div>
    <div class="field">
      <label class="label">Бюджет</label>
      <div class="field-body">
        <div class="field is-expanded">
          <div class="field has-addons">
            <p class="control">
              <a class="button is-static">
                $
              </a>
            </p>
            <p class="control is-expanded">
              <input v-model="budget" class="input" type="number">
            </p>
          </div>
        </div>
      </div>
    </div>
    <div class="field">
      <label class="label">Возрастной рейтинг</label>
      <div class="control">
        <div class="select">
          <select v-model="ageRating">
            <option v-for="r in allRatings" :key="r" :value="r">
              {{ r }}
            </option>
          </select>
        </div>
      </div>
    </div>

    <div class="field">
      <label class="label">Жанры</label>
      <div class="field-body">
        <multiselect
            mode="tags"
            :searchable="true"
            v-model="genres"
            :options="genresOptions"/>
      </div>
    </div>

    <div class="field">
      <label class="label">Языки</label>
      <div class="field-body">
        <multiselect
            mode="tags"
            :searchable="true"
            v-model="languages"
            :options="['Русский', 'English']"/>
      </div>
    </div>

    <div class="control">
      <button @click="create" class="button is-primary">Создать</button>
    </div>
  </div>
</template>

<script>
import Multiselect from '@vueform/multiselect'
import axios from "axios";

export default {
  name: "CreateMoviePage",
  components: {Multiselect},
  data() {
    return {
      name: '',
      year: new Date().getFullYear(),
      duration: 90,
      ageRating: '',
      allRatings: [],
      budget: 0,
      genres: [],
      languages: [],
      genresOptions: []
    }
  },
  created() {
    axios.get('refs/ageratings').then(response => {
      this.allRatings = response.data
      this.ageRating = this.allRatings[0]
    })
    axios.get('genres').then(response => {
      this.genresOptions = response.data.map(genreDto => genreDto.name);
    })
  },
  methods: {
    create() {
      axios.post('/movies', {
        name: this.name,
        year: this.year,
        duration: this.duration,
        ageRating: this.ageRating,
        budget: this.budget,
        genres: this.genres,
        languages: this.languages
      }).then(() => {
        console.log('Movie created')
        this.$router.push('/all')
      })
    }
  }
}
</script>

<style src="@vueform/multiselect/themes/default.css"></style>

<style scoped>

</style>
