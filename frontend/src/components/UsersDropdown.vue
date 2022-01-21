<template>
  <div class="field" id="users">
    <p class="control has-icons-left">
    <span class="select">
      <select v-model="currentIndex">
        <option @click="$emit('updated', i)" v-for="(item, i) in items" v-bind:value="i" :key="i">{{ item.name }}</option>
      </select>
    </span>
      <span class="icon is-small is-left">
      <i class="fas fa-user"></i>
    </span>
    </p>
<!--    <button class="button ml-3 is-success py-0 px-2"><i class="fas fa-plus"></i></button>-->
<!--    <div class="modal" >-->
<!--      <div class="modal-background"></div>-->
<!--      <div class="modal-content">-->
<!--        <div class="box">-->
<!--          <p>-->
<!--            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias animi consectetur consequatur cum cumque-->
<!--            deserunt distinctio ducimus eius eligendi esse, id, laborum nam natus, nesciunt possimus praesentium ratione-->
<!--            rerum voluptas?-->
<!--          </p>-->
<!--        </div>-->
<!--        &lt;!&ndash; Any other Bulma elements you want &ndash;&gt;-->
<!--      </div>-->
<!--      <button class="modal-close is-large" aria-label="close"></button>-->
<!--    </div>-->
  </div>
</template>

<script>
export default {
  name: "UsersDropdown",
  data() {
    return {
      currentIndex: 0,
      items: [
        {'name': 'jack'},
        {'name': 'john'},
        {'name': 'bruce'},
      ]
    }
  },
  created() {
    this.$emit('updated', this.currentIndex)
  }
}
</script>

<style scoped>
#users {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}
</style>